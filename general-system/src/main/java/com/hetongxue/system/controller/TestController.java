package com.hetongxue.system.controller;

import com.hetongxue.response.Result;
import com.hetongxue.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试模块
 * @ClassNmae: TestController
 * @Author: 何同学
 * @DateTime: 2022-05-29 18:34
 **/
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping
    public Result test() {
        return Result.Success().setMessage("欢迎使用,通用系统后台管理!");
    }

    @GetMapping("/datasource")
    public Result testDatasource() {
        return Result.Success(userService.getUserAll());
    }

}
