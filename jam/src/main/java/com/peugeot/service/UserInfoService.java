package com.peugeot.service;

import com.peugeot.model.UserVO;

/**
 * 用户查询接口
 * Created by 柏世民 on 2017/8/11.
 */
public interface UserInfoService {

    UserVO fetchUserByUserName(String userName);
}
