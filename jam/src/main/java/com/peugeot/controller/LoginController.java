package com.peugeot.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**登录大前端
 * Created by 柏世民 on 2017/8/7.
 */
@Controller
@AllArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";

    }
}
