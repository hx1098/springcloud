package com.example.springboot.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/7 14:04
 * @description
 * @editUser hx
 * @editTime 2022/1/7 14:04
 * @editDescription
 */
@Configuration
@Order(3)
public class test3 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("implements  BeanPostProcessor 实现springboot启动前执行....");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
