package com.mashibing.eurekaserver;


import com.sun.jndi.toolkit.url.Uri;
import com.sun.org.apache.xml.internal.utils.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.time.Period;
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

    @GetMapping("/getObj")
    public Person getObj(){
        Person zhangsan = new Person(123, "zhangsan");
        return zhangsan;
    }

    @GetMapping("/getObj2")
    public Person getObj2(String name){
        Person zhangsan = new Person(123, name);
        return zhangsan;
    }

    /**
     * 通过这个可以跳转到百度搜索
     * @param person
     * @param response
     * @return
     * @throws MalformedURLException
     */
    @PostMapping("/postLocaltion")
    public Uri postLocaltion(@RequestBody Person person, HttpServletResponse response) throws MalformedURLException {
        Uri uri = new Uri("https://www.baidu.com/s?wd=" + person.getName().trim());
        System.out.println(uri.toString());
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());
        response.setHeader("Location",uri.toString());
        return uri;
    }


}
