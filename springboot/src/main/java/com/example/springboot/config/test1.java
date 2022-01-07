package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/7 13:56
 * @description
 * @editUser hx
 * @editTime 2022/1/7 13:56
 * @editDescription
 */
@Configuration
@Order(1)
public class test1 {


    @Autowired
    private Environment environment;

    @PostConstruct
    public void test() {
        System.out.println("PostConstructTest 实现springboot启动前执行....");
    }



}
