package com.mashibing.eurekaserver;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


//    定义负载均衡
   /* @Bean
    public IRule myRule(){
        return new RandomRule();
//        return new RetryRule();
//        return new RoundRobinRule();
    }*/
}
