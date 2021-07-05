package com.cn.hx.spseeesion01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/7/4 19:46
 * @option
 * @description
 * @editUser hx
 * @editTime 2021/7/4 19:46
 * @editDescription
 */
@RestController
public class Mycontroller {

    @GetMapping("set")
    public String list(HttpServletRequest request){
        request.getSession().setAttribute("aaa", "ooo");
        return "xx00";
    }

    @GetMapping("get")
    public String get(HttpServletRequest request){
        Object attribute = request.getSession().getAttribute("aaa");
        System.out.println(attribute.toString());
        return "xx00";
    }


}
