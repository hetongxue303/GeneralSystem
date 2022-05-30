package com.hetongxue.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description: 验证码异常
 * @ClassNmae: CaptchaException
 * @Author: 何同学
 * @DateTime: 2022-05-30 19:40
 **/
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg) {
        super(msg);
    }

    public CaptchaException(String msg, Throwable cause) {
        super(msg, cause);
    }

}