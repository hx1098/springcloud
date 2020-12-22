package com.mashibing.eurekaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Value("${server.port}")
    String port;


    @GetMapping("/getHi")
    public String getHi(){
        return  "Hi,我的port是" + port;
    }

    @GetMapping("/client")
    public String client(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        return "Hi";
    }

    @Autowired
    HealthStatusService healthStatusService;

    /**
     * 使用healthStatusService让服务进行上下线
     * @param status
     * @return
     */
    @GetMapping("/health")
    public String health(@RequestParam("status")Boolean status){
        healthStatusService.setStatus(status);
        return healthStatusService.getStatus();
    }

    @GetMapping("/getMap")
    public Map<String, String> getMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "500");
        return map;
    }



}
