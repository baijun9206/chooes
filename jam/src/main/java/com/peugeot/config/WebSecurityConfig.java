package com.peugeot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全机制
 * Created by 柏世民 on 2017/8/9.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private JamUserDetailsService jamUserDetailsService;

    @Autowired
    public void  setJamUserDetailsService(JamUserDetailsService jamUserDetailsService){
        this.jamUserDetailsService = jamUserDetailsService;
    }
    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and()
                 .logout().logoutUrl("/logout").logoutSuccessUrl("/login");

    }

    /**
     * 添加 UserDetailsService， 实现自定义登录校验
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jamUserDetailsService);
    }
}
