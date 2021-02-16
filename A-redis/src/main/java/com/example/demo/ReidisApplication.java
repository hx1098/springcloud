package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReidisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cts = SpringApplication.run(ReidisApplication.class, args);
        TestRedis redis = cts.getBean(TestRedis.class);
        redis.testRedis();
    }

}
