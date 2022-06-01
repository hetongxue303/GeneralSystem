package com.hetongxue.security.service;

import com.hetongxue.system.domain.User;
import com.hetongxue.system.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 自定义UserDetailsService
 * @ClassNmae: CustomizeUserDetailsService
 * @Author: 何同学
 * @DateTime: 2022-05-30 19:45
 **/
@Component
public class CustomizeUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 前端需要使用表单提交 不然username为null
        User user = userService.getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("用户名或密码错误");
        return user;
    }

}