package com.mq.acvitvemq.queueAndTopic04;

import javax.jms.*;

/**
 * @author hx
 * @createTime 2021/5/2 15:26
 * @option
 * @description
 */
public class MyLisener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage test = (TextMessage) message;
            try {
                System.out.println(test.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        if(message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                Girl object = (Girl) objectMessage.getObject();
                System.out.println(object.getName());
                System.out.println(object.getAge());
                System.out.println(object.getPrice());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        if(message instanceof MapMessage){
            MapMessage mapMessage = (MapMessage) message;
            System.out.println(mapMessage);
            try {
                System.out.println(mapMessage.getString("name"));
                System.out.println(mapMessage.getInt("age"));
                System.out.println(mapMessage.getDouble("price"));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
