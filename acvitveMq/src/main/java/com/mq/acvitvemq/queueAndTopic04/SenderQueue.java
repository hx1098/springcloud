package com.mq.acvitvemq.queueAndTopic04;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * @author hx
 * @createTime 2021/5/1 15:26
 * @option
 * @description 发送者
 *
 * mq : 注意事项:　１．　如果有两个消费者，　在开启确认机制的情况下，　ｍｑ给到一个ｃｏｎｓｕｍｅｒ，会等待consumer进行确认, 如果一直不确认, session会话存在时间段内, 会一直等待,
 * 直到session结束,  如果consumer挂掉了, 又上来了, 就会重复进行消费.
 */
public class SenderQueue {
    public static void main(String[] args) throws JMSException, InterruptedException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin",
                "admin",
                "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection.start();
        Queue queue = session.createQueue("xxoo");

        MessageProducer producer = session.createProducer(queue);

        TextMessage textMessage = session.createTextMessage("Message from ServerA xx..");




        producer.send(textMessage);





        System.out.println("System exit.....");
        connection.close();

    }


}

