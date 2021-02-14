package com.mashibing.eurekaserver;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hx
 * @createTime 2020/12/24 14:51
 * @option  这里来实现这个UserApi
 * @description
 */
@RestController
public class UserController implements UserApi{



    @Value("${server.port}")
    String port;

    private AtomicInteger count  = new AtomicInteger();




    @Override
    public String isAlive(){
        try {
            System.out.println("准备睡");

            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int i = count.getAndIncrement();
        System.out.println("====好的第：" + i + "次调用");
        return "port:" + port;
    }

    @Override
    public Integer getById(Integer id) {
        System.out.println("当前的id的值是: " + id);
        return id;
    }

    @GetMapping("/getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id) {
        System.out.println(id);
        return Collections.singletonMap(id, "mmeme");
    }

    @GetMapping("/getMap2")
    public Map<Integer, String> getMap2(Integer id,String name) {
        System.out.println(id);
        return Collections.singletonMap(id, name);
    }

    @GetMapping("/getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }


    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @PostMapping("/postPerson")
    public Person postMap2(@RequestBody Person person) {
        System.out.println(ToStringBuilder.reflectionToString(person));
        return person;
    }


}
