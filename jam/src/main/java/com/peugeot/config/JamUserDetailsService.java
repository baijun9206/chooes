package com.peugeot.config;

import com.peugeot.model.UserVO;
import com.peugeot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 柏世民 on 2017/8/11.
 */
@Service
public class JamUserDetailsService implements UserDetailsService {

    private final UserInfoService userInfoService;

    @Autowired
    public JamUserDetailsService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO user = userInfoService.fetchUserByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(user.getRoles());
        return new User(user.getUserName(), user.getPassWord(), simpleGrantedAuthorities);
    }
    /**
     * 权限字符串转化
     *
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     *
     * @param roleStr 权限字符串
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }
}
