package com.mashibing.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/5 21:51
 */
@EnableHystrixDashboard //这个注解不是dashboard 包里的, 是actorator包中的
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class UserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class);
        System.out.println(123);
    }
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        //将自定一的restemplate 的拦截器加入到启动中
//        restTemplate.getInterceptors().add(new LoggingClientHttpRequestInterceptor());
        return restTemplate;
    }

}
