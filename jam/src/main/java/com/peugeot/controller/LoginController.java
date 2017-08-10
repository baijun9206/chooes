package com.peugeot.controller;

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

    @RequestMapping("/index")
    public String index(){
        return "common/index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "common/hello";
    }
    @RequestMapping("/")
    @ResponseBody
    public String hey(){
        return "你好!";
    }
}
