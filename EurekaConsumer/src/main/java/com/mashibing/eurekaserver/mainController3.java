package com.mashibing.eurekaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
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
public class mainController3 {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private LoadBalancerClient lb;
    @Autowired
    DiscoveryClient discoveryClient;


    /**
     * 这样也可以访问到远程接口
     * @return
     */
    @GetMapping("client10")
    public Object client9(){
        String url =  "http://provider/getHi";
        System.out.println(url);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity);

        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }

    @GetMapping("getMap")
    public ResponseEntity<Map>  getMap(){
        String url =  "http://provider/getMap";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);
        return  forEntity;
    }

    @GetMapping("client12")
    public Object  getObj(){
        String url =  "http://provider/getObj";
        ResponseEntity<Person> forEntity = restTemplate.getForEntity(url, Person.class);
        return  forEntity;
    }
    @GetMapping("client13")
    public Object  getObj2(){
        String url =  "http://provider/getObj2?name={1}";
        ResponseEntity<Person> forEntity = restTemplate.getForEntity(url, Person.class,"malaoshi777777");
        return  forEntity;
    }

    @GetMapping("client14")
    public Object  getObj3(){
        String url =  "http://provider/getObj2?name={name}";
        Map<String, String> stringStringMap = Collections.singletonMap("name", "牛逼人");
        Person forEntity = restTemplate.getForObject(url, Person.class,stringStringMap);
        return  forEntity;
    }





}
