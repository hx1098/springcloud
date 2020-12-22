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
import java.util.concurrent.atomic.AtomicInteger;

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



    @Autowired
    DiscoveryClient discoveryClient;
    /**
     * s手动负载均衡
     * @return
     */
    @GetMapping("client7")
    public Object client7(){
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        //自定义轮训算法(随机)
        int nextInt = new Random().nextInt(instances.size());

        //轮询
        /*AtomicInteger atomicInteger = new AtomicInteger();
        int andIncrement = atomicInteger.getAndIncrement();
        instances.get(i % instances.size());*/

      /*  for (ServiceInstance instance : instances) {
            instance.getMetadata();//权重1-9
        }*/

        System.out.println("instance" + instances);

        ServiceInstance provider = instances.get(nextInt);
        /* ServiceInstance provider = lb.choose("provider");*/

        String url =  "http://"+provider.getHost() +":"+ provider.getPort()+"/getHi";

        String forObject = restTemplate.getForObject(url, String.class);

        System.out.println(provider.getPort());

        return forObject;
    }


    /**
     * 使用配置文件properties 定义负载均衡策略
     *
     * @return
     */
    @GetMapping("client8")
    public Object client8(){
        ServiceInstance provider = lb.choose("provider");

        String url =  "http://"+provider.getHost() +":"+ provider.getPort()+"/getHi";

        String forObject = restTemplate.getForObject(url, String.class);

        return forObject;
    }


    /**
     * 这样也可以访问到远程接口
     * @return
     */
    @GetMapping("client9")
    public Object client9(){
        String url =  "http://provider/getHi";

        System.out.println(url);
        String forObject = restTemplate.getForObject(url, String.class);

        return forObject;
    }



}
