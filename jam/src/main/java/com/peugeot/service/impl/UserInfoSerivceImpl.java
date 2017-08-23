package com.peugeot.service.impl;

import com.peugeot.dao.UserInfoDao;
import com.peugeot.model.UserVO;
import com.peugeot.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 柏世民 on 2017/8/11.
 */
@Service
public class UserInfoSerivceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userDao;

    @Override
    public UserVO fetchUserByUserName(String userName) {
        //用户名是否为空
        if(StringUtils.isEmpty(userName)){
            return null;
        }
        return userDao.fetchUserByUserName(userName);
    }
}
