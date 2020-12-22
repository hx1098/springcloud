package com.mashibing.eurekaserver;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/5 21:58
 */
@RestController
public class mainController2 {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private LoadBalancerClient lb;

    @GetMapping("client6")
    public Object client6(){
        ServiceInstance provider = lb.choose("provider");

        String url =  "http://"+provider.getHost() +":"+ provider.getPort()+"/getHi";
        System.out.println(url);

        String forObject = restTemplate.getForObject(url, String.class);

        System.out.println(provider.getPort());

        return forObject;
    }

    @GetMapping("getMap")
    public ResponseEntity<Map>  getMap(){
        ServiceInstance provider = lb.choose("provider");
        String url =  "http://"+provider.getHost() +":"+ provider.getPort()+"/getMap";
        ResponseEntity<Map> entity  = restTemplate.getForEntity(url,Map.class);
        System.out.println("respStr" + entity);
        return  entity;
    }





}
