package com.creditcrest.ccs.service;

import com.alibaba.druid.util.StringUtils;
import com.creditcrest.ccs.common.Constant;
import com.creditcrest.ccs.common.pojo.AjaxResult;
import com.creditcrest.ccs.common.pojo.Identity;
import com.creditcrest.ccs.common.pojo.ParamData;
import com.creditcrest.ccs.common.util.CookieUtil;
import com.creditcrest.ccs.common.util.DateUtil;
import com.creditcrest.ccs.common.util.MD5Util;
import com.creditcrest.ccs.mapper.AuthRoleMapper;
import com.creditcrest.ccs.mapper.AuthUserMapper;
import com.creditcrest.ccs.model.AuthRole;
import com.creditcrest.ccs.model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dx0001 on 2017/7/3.
 */
@Service("loginService")
public class LoginService{

    @Autowired
    private AuthUserMapper userMapper;

    @Autowired
    private AuthRoleMapper roleMapper;

    public AjaxResult login(HttpServletRequest request, HttpServletResponse response) {
        //获取验证码值
        String verifyCode = (String) request.getSession().getAttribute(Constant.VERIFY_CODE);
        //返回值
        String result = "";
        //封装Request参数
        ParamData paramData = new ParamData();
        String vcode = paramData.getString("vcode");
        //校验验证码
        if (paramData.containsKey("vcode") && (StringUtils.isEmpty(verifyCode) || !verifyCode.equalsIgnoreCase(vcode))) {
            result = "验证码错误";
        } else {
            String username = paramData.getString("username");
            String loginIp = paramData.getString("loginIP");
            String key = username + loginIp + Constant.LOGIN_ERROR_TIMES;
            //查询登录用户是否存在
            AuthUser user = userMapper.queryByUsername(username);
            //判断用户是否为空,密码校验
            if (null == user || user.getPassword().equals(paramData.getString("password"))) {
                //记录密码错误次数,达到3次则需要输出验证码
//                int errTimes = dataCache.getInt(key);
//                dataCache.setValue(key, errTimes += 1);
//                result = "用户名或密码错误|" + errTimes;
            } else if (Constant.ROLE_ANONYMOUS.equals(user.getRole().getRolename())) {
                result = "用户未分组,无法登录";
            } else {
                // 更新登录IP和登录时间
                user.setLoginip(loginIp);
                user.setLogintime(DateUtil.getCurDateTime());
                userMapper.updateByPrimaryKeySelective(user);

                Identity identity = new Identity();
                AuthRole role = roleMapper.queryRoleById(user.getRoleid());

                identity.setOperationList(role.getOperations());
                identity.setLoginUser(user);
                identity.setLoginIp(loginIp);
                String sessionId = getSessionId(username, identity.getLoginIp());
                identity.setSessionId(sessionId);
//                dataCache.setValue(username + loginIp, identity);
//                dataCache.setValue(sessionId, username);
//                dataCache.remove(key);
                CookieUtil.set(Constant.SESSION_IDENTITY_KEY, sessionId, response);
            }
        }
        return new AjaxResult(result);
    }
    private String getSessionId(String userName, String ip) {
        String str = userName + "_" + System.currentTimeMillis() + "_" + ip;
        try {
            return MD5Util.encrypt(str);
        } catch (Exception e) {
            return "生成token错误";
        }
    }
}
