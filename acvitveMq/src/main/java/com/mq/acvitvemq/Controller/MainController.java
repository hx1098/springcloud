package com.mq.acvitvemq.Controller;

import com.mq.acvitvemq.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hx
 * @createTime 2021/5/3 22:23
 * @option
 * @description
 */
@RestController
public class MainController {


    @Autowired
    SenderService senderService;

    @RequestMapping("/send")
    public String send(){
//        senderService.send("spring boot","hello !!!!");
        senderService.send2("spring boot","hello !!!!");
        return "ok";
    }
}
