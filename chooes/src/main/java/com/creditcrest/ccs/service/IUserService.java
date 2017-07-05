package com.creditcrest.ccs.service;

import com.creditcrest.ccs.model.AuthUser;

import java.util.List;

/**用户管理接口
 * Created by 柏世民 on 2017/7/4.
 */
public interface IUserService {

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    AuthUser fectchUserById(Integer id);

    /**
     * 所用用户
     * @return
     */
    List<AuthUser> queryListAll();
}
