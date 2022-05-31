package com.hetongxue.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hetongxue.lang.Const;
import com.hetongxue.security.exception.CaptchaException;
import com.hetongxue.security.handler.LoginFailureHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Description: 验证码过滤器
 * @ClassNmae: CaptchaFilter
 * @Author: 何同学
 * @DateTime: 2022-05-31 16:21
 **/
@Component
@RequiredArgsConstructor
public class CaptchaFilter extends OncePerRequestFilter {

    private final LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (request.getRequestURI().equals("/login") && request.getMethod().equalsIgnoreCase("POST")) {
                String code = (String) new ObjectMapper().readValue(request.getInputStream(), Map.class).get("code");
                String sessionCode = (String) request.getSession().getAttribute(Const.CAPTCHA_KEY);
                if (code == null || code.equals("")) throw new CaptchaException("验证码不能为空！");
                if (sessionCode == null || sessionCode.equals("")) throw new CaptchaException("验证码过期");
                if (!code.equals(sessionCode)) throw new CaptchaException("验证码不一致");
                request.getSession().removeAttribute(Const.CAPTCHA_KEY);
            }
            filterChain.doFilter(request, response);
        } catch (CaptchaException e) {
            loginFailureHandler.onAuthenticationFailure(request, response, e);
        }
    }

}