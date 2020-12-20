package com.mashibing.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/5 21:51
 */

@SpringBootApplication
public class EurekaCousumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCousumerApplication.class);
    }

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
