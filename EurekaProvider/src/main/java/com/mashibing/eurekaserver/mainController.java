package com.mashibing.eurekaserver;

import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/5 21:58
 */
@RestController
public class mainController {

    @Autowired
    DiscoveryClient client;

    @GetMapping("/getHi")
    public String getHi(){
        return  "Hi";
    }

    @GetMapping("/client")
    public String client(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        return "Hi";
    }



}
