package com.mq.acvitvemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.ObjectMessage;

/**
 * @author hx
 * @createTime 2021/5/3 22:35
 * @option
 * @description 收消息
 */
@Service
public class Receiver {

    @JmsListener(destination = "spring boot",containerFactory = "jmsListenerContainerTopic")
    public void receiver(String msg){
        System.out.println("收到消息:　"+ msg);
    }

}
