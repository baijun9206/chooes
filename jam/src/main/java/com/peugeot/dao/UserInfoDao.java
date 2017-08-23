package com.peugeot.dao;

import com.peugeot.model.UserVO;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 用户Dao
 * Created by 柏世民 on 2017/8/11.
 */
@MapperScan
public interface UserInfoDao {

    UserVO fetchUserByUserName(@Param("userName") String userName);
}
