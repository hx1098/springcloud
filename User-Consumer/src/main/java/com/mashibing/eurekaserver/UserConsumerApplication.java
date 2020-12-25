package com.mashibing.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/5 21:51
 */
@EnableFeignClients
@SpringBootApplication
public class UserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class);
        System.out.println(123);
    }

}
