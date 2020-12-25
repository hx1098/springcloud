package com.mashibing.eurekaserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hx
 * @createTime 2020/12/24 14:51
 * @option  这里来实现这个UserApi
 * @description
 */
@RestController
public class UserController implements UserApi{


    @Override
    public String isAlive(){
        System.out.println("111111111111111111111111");
        return "ouyeel is Alive!";
    }

}
