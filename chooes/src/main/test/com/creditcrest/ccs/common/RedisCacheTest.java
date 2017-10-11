package com.creditcrest.ccs.common;

import com.creditcrest.ccs.model.AuthUser;
import com.creditcrest.ccs.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by dx0001 on 2017/7/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring-context.xml")
@WebAppConfiguration(value = "src/main/resources")
public class RedisCacheTest {

    @Autowired
    public IUserService userService;

    @Test
    public void fetchUserTest(){

        AuthUser user = userService.fectchUserById(20);
        System.out.println(user.toString());
    }

    @Test
    public void listUserTest(){
        System.out.println("数据列表");
        List<AuthUser> authUsers = userService.queryListAll();
        for (AuthUser user : authUsers) {
            System.out.println(user.toString());

        }

    }

}
