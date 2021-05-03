package com.mq.acvitvemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/5/3 22:24
 * @option
 * @description 发送消息
 */
@Service
public class SenderService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;


    public void send(String destination, String payload) {
        jmsMessagingTemplate.convertAndSend(destination,payload);
    }

    public void send2(String destination, String payload) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("xx 0000");
                textMessage.setStringProperty("hehe", "enen");
                return  textMessage;
            }
        });
    }


}
