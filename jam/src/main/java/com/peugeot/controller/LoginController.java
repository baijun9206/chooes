package com.peugeot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**登录大前端
 * Created by 柏世民 on 2017/8/7.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PreAuthorize("hasRole('Role_ADMIN')")
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/")
    @ResponseBody
    public String hey(){
        return "你好!";
    }
}
