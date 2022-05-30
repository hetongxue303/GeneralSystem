package com.hetongxue.security.service;

import com.hetongxue.system.domain.User;
import com.hetongxue.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Description: 自定义UserDetailsService
 * @ClassNmae: CustomizeUserDetailsService
 * @Author: 何同学
 * @DateTime: 2022-05-30 19:45
 **/
@Component
@RequiredArgsConstructor
public class CustomizeUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("用户名或密码错误");
        return user;
    }
}
