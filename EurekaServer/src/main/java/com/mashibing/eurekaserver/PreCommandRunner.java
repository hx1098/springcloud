package com.mashibing.eurekaserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/10 16:40
 * @description
 * @editUser hx
 * @editTime 2021/11/10 16:40
 * @editDescription 测试springboot 先执行的方法
 */
@Component
@Order(1)
public class PreCommandRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("=============> 自定一个的方法开始执行了1111....");
    }
}
