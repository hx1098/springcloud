package com.mq.acvitvemq.queueAndTopic04;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.util.Enumeration;

/**
 * @author hx
 * @createTime 2021/5/1 15:26
 * @option
 * @description 消息接收
 */
public class BrowserQueue {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin",
                "admin",
                "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(new ActiveMQQueue("xxoo"));

        QueueBrowser browser = session.createBrowser(new ActiveMQQueue("xxoo"));
        Enumeration enumeration = browser.getEnumeration();
        while (enumeration.hasMoreElements()) {
            TextMessage textMessage =  (TextMessage)enumeration.nextElement();
            System.out.println(textMessage.getText());
            
        }

       /* consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

            }
        });*/



    }


}
