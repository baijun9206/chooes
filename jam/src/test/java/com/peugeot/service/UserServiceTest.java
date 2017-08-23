package com.peugeot.service;

import com.peugeot.model.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**用户接口测试
 * Created by 柏世民 on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void usetTest(){
        UserVO userVO = userInfoService.fetchUserByUserName("baism");
        System.out.println("看这里哟:"+userVO);
    }
}
