package com.hetongxue.system.controller;

import com.hetongxue.response.Result;
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
public class TestController {

    @GetMapping
    public Result test() {
        return Result.Success().setMessage("欢迎使用,通用系统后台管理!");
    }

}
