package com.creditcrest.ccs.controller;

import com.creditcrest.ccs.common.pojo.AjaxResult;
import com.creditcrest.ccs.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**登录大前端
 * Created by dx0001 on 2017/7/3.
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录首页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(HttpServletRequest request,HttpServletResponse response){
        return loginService.login(request,response);
    }

}
