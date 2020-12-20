package com.mashibing.eurekaserver;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/5 21:58
 */
@RestController
public class mainController2 {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient client;
    @Autowired
    EurekaClient client2;
    @Autowired
    LoadBalancerClient lb;

    @GetMapping("client6")
    public Object client6(){
        ServiceInstance provider = lb.choose("provider");

        String url =  "http://"+provider.getHost() +":"+ provider.getPort()+"/getHi";
        System.out.println(url);

        String forObject = restTemplate.getForObject(url, String.class);

        System.out.println(forObject);
        return forObject;
    }





}
