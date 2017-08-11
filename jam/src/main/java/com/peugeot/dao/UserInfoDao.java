package com.peugeot.dao;

import com.peugeot.model.UserVO;

/**
 * 用户Dao
 * Created by 柏世民 on 2017/8/11.
 */
public interface UserInfoDao {

    UserVO fetchUserByUserName(String userName);
}
