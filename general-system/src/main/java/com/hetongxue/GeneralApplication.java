package com.hetongxue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: 程序入口类
 * @ClassNmae: GeneralApplication
 * @Author: 何同学
 * @DateTime: 2022-05-29 18:31
 **/
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.hetongxue.system.mapper")
public class GeneralApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralApplication.class, args);
    }

}
