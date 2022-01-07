package com.example.springboot.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/7 14:00
 * @description
 * @editUser hx
 * @editTime 2022/1/7 14:00
 * @editDescription
 */
@Order(2)
@Configuration
public class test2 implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("implements  InitializingBean 实现springboot启动前执行....");
    }
}
