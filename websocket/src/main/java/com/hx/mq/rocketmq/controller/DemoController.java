package com.hx.mq.rocketmq.controller;

import com.hx.mq.rocketmq.config.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/3 14:31
 * @description
 * @editUser hx
 * @editTime 2021/12/3 14:31
 * @editDescription
 */
@RestController
public class DemoController {

    @GetMapping("index2")
    public ResponseEntity<String> index2(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

}
