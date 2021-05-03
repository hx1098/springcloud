package com.mq.acvitvemq.queueAndTopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author hx
 * @createTime 2021/5/1 15:26
 * @option
 * @description 消息接收
 */
public class ReceiverQueue {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin",
                "admin",
                "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
//        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("user");
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MyLisener());





    }


}
