package com.mashibing.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description:  消息总线<br>
 * @date 2020/12/5 21:51
 */

@SpringBootApplication
@EnableConfigServer
public class CnfigCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CnfigCenterApplication.class);
        System.out.println(123);
    }

}
