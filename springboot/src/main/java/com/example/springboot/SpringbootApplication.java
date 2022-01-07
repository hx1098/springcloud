package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringbootApplication.class, args);

        SpringApplication application = new SpringApplication(SpringbootApplication.class);
        //1.这里是可以作为缓存预热的操作....
        for (int i = 0; i < 10; i++) {
            System.out.println( "[张三"+i+"]又开始违法了....");
        }
        application.run();
    }

}
