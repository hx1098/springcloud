package com.mashibing.eurekaserver;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope//RefreshScope刷新
public class mainController {

    @Autowired
    DiscoveryClient client;
    @Autowired
    EurekaClient client2;
    @Autowired
    LoadBalancerClient lb;
    @Value("${myconfig}")
    String myconfig;

    @GetMapping("myconfig")
    public String getMapping(){
        return myconfig;
    }

    /*http://laptop-3850r394:90/myconfig*/
    @GetMapping("/client")
    public String client(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        return "Hi";
    }

    @GetMapping("client2")
    public Object client2(){
        return client.getInstances("provider");
    }
    @GetMapping("client3")
    public Object client3(){
        List<ServiceInstance> provider = client.getInstances("provider");
        for (ServiceInstance serviceInstance : provider) {
            System.out.println(ToStringBuilder.reflectionToString(serviceInstance));
        }
        return "xxoo";
    }

    @GetMapping("client4")
    public Object client4(){

//        List<InstanceInfo> provider = client2.getInstancesById("LAPTOP-3850R394:provider:81");//具体的一个服务
        List<InstanceInfo> provider = client2.getInstancesByVipAddress("provider", false);//使用服务名找多个
        for (InstanceInfo serviceInstance : provider) {
            System.out.println(ToStringBuilder.reflectionToString(serviceInstance));
        }
        if (provider.size()>0){
            InstanceInfo instanceInfo = provider.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP){
               String url =  "http://"+instanceInfo.getHostName() +":"+ instanceInfo.getPort()+"/getHi";
                System.out.println(url);

                RestTemplate restTemplate = new RestTemplate();

                String forObject = restTemplate.getForObject(url, String.class);

                System.out.println(forObject);
            }
        }
        return "xxo";
    }

    /**
     * 使用ribbon的负载均衡
     * @return
     */
    @GetMapping("client5")
    public Object client5(){
        ServiceInstance provider = lb.choose("provider");

        String url =  "http://"+provider.getHost() +":"+ provider.getPort()+"/getHi";
        System.out.println(url);

        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject(url, String.class);

        System.out.println(forObject);
        return "xxo";
    }





}
