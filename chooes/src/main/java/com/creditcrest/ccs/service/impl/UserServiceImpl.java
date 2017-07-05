package com.creditcrest.ccs.service.impl;

import com.creditcrest.ccs.common.Constant;
import com.creditcrest.ccs.mapper.AuthUserMapper;
import com.creditcrest.ccs.model.AuthUser;
import com.creditcrest.ccs.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**用户信息功能实现
 * Created by dx0001 on 2017/7/4.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AuthUserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public AuthUser fectchUserById(Integer id) {
        //从缓存中获取用户信息
        String key = Constant.USER_KEY+id;
        ValueOperations<String,AuthUser> operations = redisTemplate.opsForValue();

        //缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            AuthUser user = operations.get(key);
            LOGGER.info("UserServiceImpl.fectchUserById():从缓存中获取了用户 >>{}",  user.toString());
            return user;
        }
        //从DB获取用户信息
        AuthUser user = userMapper.queryUserById(id);
        //插入缓存
        operations.set(key,user);
        LOGGER.info("UserServiceImpl.fectchUserById():用户插入缓存 >>{}",  user.toString());
        return user;
    }

    @Override
    public List<AuthUser> queryListAll() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(Constant.USER_LIST);
        if (hasKey) {
            List<AuthUser> userList = (List<AuthUser>) operations.get(Constant.USER_LIST);
            LOGGER.info("UserServiceImpl.queryListAll():从缓存中获取了用户列表 >>{}", userList.toString());
            return userList;
        }
        List<AuthUser> userList = userMapper.queryListAll();
        operations.set(Constant.USER_LIST,userList);
        LOGGER.info("UserServiceImpl.queryListAll():用户插入缓存 >>{}", userList.toString());
        return userList;
    }
}
