package com.mashibing.eurekaserver;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author hx
 * @createTime 2020/12/24 22:48
 * @option
 * @description
 */
@RestController
public class MainController {

    @Autowired
    public ConsumerAPI userApi;

  /*  @Autowired
    MashibingApi mapi;*/

    @Value("${server.port}")
    String port;

    @Autowired
    RestService restService;

    @GetMapping("/blive")
    public String blive(){
        return "Consumer" + port+ "->>>>>"+ restService.blive();
    }


    @GetMapping("/alive")
    public String Alive(){
        return userApi.isAlive();
    }


    @GetMapping("/getById")
    Integer getById(@RequestParam("id") Integer id){
        System.out.println(id);
        return  userApi.getById(id);
    }

   /* @Autowired
    MashibingApi mapi;

    @GetMapping("/alive")
    public String alive() {
        *//**
         * URL 不能变
         *
         * jar
         * 文档
         *//*
        return api.alive();
    }

     @GetMapping("/vip")
    public String vip() {

        return mapi.getVip();
    }

  /*  @GetMapping("/map")
    public Map<Integer, String> map(Integer id) {
        System.out.println(id);
        return userApi.getMap(id);
    }*/

   /* @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id,String name) {
        System.out.println(id);
        return userApi.getMap2(id,name);
    }


    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return userApi.getMap3(map);
    }


    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return userApi.postMap(map);
    }


    /**
     *  这里的Map<String,Object> map  必须要加  @RequestParam
     * @param map
     * @return
     */
    @GetMapping("/postPerson")
    public Person postPerson(@RequestParam Map<String,Object> map) {
        System.out.println(map);
        Person person = new Person();
        person.setId(Integer.parseInt(map.get("id").toString()));
        person.setName("OxxO");
        return userApi.postPerson(person);
    }







}
