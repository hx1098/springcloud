package com.mq.acvitvemq.queueAndTopic04;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

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
public class SenderTopic {


    //    1.获取链接工厂
//    2.获q取一个向mq的链接
//    3.获取session
//    4.找目的地,获取desinatino,消费端,从目的地获取消息
//    5、项目的的写入消息
//    6.关闭链接
    public static void main(String[] args) throws JMSException, InterruptedException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin",
                "admin",
                "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination topic = session.createTopic("user");
        MessageProducer producer = session.createProducer(topic);

        TextMessage textMessage = session.createTextMessage("Hi, my name is hx");

        long delay  = 10 * 1000;
        int peat = 9;
        int period = 2 * 1000;
        textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,delay);
//        repeat是int类型的.
        textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT,peat);
        textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD,period);

        producer.send(textMessage);




        connection.close();
        System.out.println("system exit.....");


    }

}