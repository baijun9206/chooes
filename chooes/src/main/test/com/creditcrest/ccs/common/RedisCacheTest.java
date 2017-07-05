package com.creditcrest.ccs.common;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dx0001 on 2017/7/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisCacheTest {

//    @Autowired
//    public IUserService userService;

    @Test
    public void fetchUserTest(){

      /*  AuthUser user = userService.fectchUserById(15);
        System.out.println(user.toString());*/
    }

}
