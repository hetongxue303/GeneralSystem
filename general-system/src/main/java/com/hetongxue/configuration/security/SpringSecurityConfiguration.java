package com.hetongxue.configuration.security;

import com.hetongxue.security.handler.*;
import com.hetongxue.security.service.CustomizeUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description: SpringSecurity配置类
 * @ClassNmae: SpringSecurityConfiguration
 * @Author: 何同学
 * @DateTime: 2022-05-30 13:15
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String[] WHITE_LIST = {"/login", "/getVerify"};
    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginFailureHandler loginFailureHandler;
    private final CustomizeLogoutSuccessHandler logoutSuccessHandler;
    private final CustomizeAccessDeniedHandler accessDeniedHandler;
    private final CustomizeAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomizeUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登陆认证处理
        http.authorizeRequests().antMatchers(WHITE_LIST).permitAll().anyRequest().authenticated()
                .and().formLogin().loginProcessingUrl("/login").successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
                .and().logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler)
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置认证处理器
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}