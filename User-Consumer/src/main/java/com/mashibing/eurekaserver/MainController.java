package com.mashibing.eurekaserver;

import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/alive")
    public String Alive(){
        return userApi.isAlive();
    }


    @GetMapping("/getById")
    Integer getById(@RequestParam("id") Integer id){
        System.out.println(id);
        return  userApi.getById(id);
    }


}
