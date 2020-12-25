package com.mashibing.eurekaserver;

import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public UserApi userApi;

    @GetMapping("/alive")
    public String Alive(){
        return userApi.isAlive();
    }


}
