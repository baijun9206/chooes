package com.creditcrest.ccs.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis缓存工具类
 * Created by dx0001 on 2017/7/4.
 */
public class RedisCacheUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    
}
