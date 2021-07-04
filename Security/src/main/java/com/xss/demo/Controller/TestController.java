package com.xss.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/23 14:12
 * @option
 * @description
 */

@Controller
public class TestController {


  /*  @GetMapping("/hi")
    public String get(){
        System.out.println("hello 2");
        return "hello";
    }*/

    @GetMapping("/login.html")
    public String getString(){
        System.out.println("hello ,1");
        return "login";
    }

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }


}
