package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.PermissionAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/27 10:01
 * @description
 * @editUser hx
 * @editTime 2021/12/27 10:01
 * @editDescription
 */
@RestController
@RequestMapping(value = "/aop")
public class AopTest01Controller {

    @GetMapping(value = "/getTest")
    public JSONObject aopTest() {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }

    @PostMapping(value = "/postTest")
    public JSONObject aopTest2(@RequestParam("id") String id) {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }

    @PostMapping(value = "/permission")
    @PermissionAnnotation()
    public JSONObject test02(@RequestBody JSONObject request) {
      /*  try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }


}
