package com.creditcrest.ccs.controller;

import com.creditcrest.ccs.model.AuthUser;
import com.creditcrest.ccs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**用户信息Controller
 * Created by dx0001 on 2017/7/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/fetchUser")
    @ResponseBody
    public AuthUser fetctUser(Integer id){
        return userService.fectchUserById(id);
    }

    @RequestMapping("/UserAll")
    @ResponseBody
    public Object queryUserALL(){
        return userService.queryListAll();
    }

}
