package com.mashibing.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/5 21:51
 */

@SpringBootApplication
public class UserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class);
        System.out.println(123);
    }

}
