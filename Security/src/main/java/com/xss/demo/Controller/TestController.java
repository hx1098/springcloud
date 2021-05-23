package com.xss.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/5/23 14:12
 * @option
 * @description
 */

@RestController
public class TestController {

    @GetMapping("/login")
    public ModelAndView getString(){
        System.out.println("hello");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }



}
