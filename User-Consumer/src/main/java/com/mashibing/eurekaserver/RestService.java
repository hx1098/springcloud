package com.mashibing.eurekaserver;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hx
 * @createTime 2021/2/16 22:24
 * @option
 * @description
 */

@Service
public class RestService {

    @Autowired
    RestTemplate template;

    @HystrixCommand(defaultFallback = "back")
    public String blive() {
        String url =  "http://user-provider/blive";
        String forEntity = template.getForObject(url, String.class);
        return forEntity;

    }

    public String back(){
        return  "heheda";
    }
}
