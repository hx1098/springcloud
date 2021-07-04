package com.xss.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/23 14:12
 * @option
 * @description
 */

@RestController
public class HiController {


    @GetMapping("/hiM")
    public String get(){
        System.out.println("来了,老弟!");
        return "hello";
    }



}
