package com.mq.acvitvemq.queueAndTopic;

import org.apache.activemq.ActiveMQConnectionFactory;

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


//        自动确认
//        手动确认的session 事物必须是false, 否则会抛异常
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("user");

        MessageProducer producer = session.createProducer(queue);

        MapMessage map = session.createMapMessage();
        map.setString("name", "xiaoa");
        map.setInt("age", 18);
        map.setDouble("price", 398);

        producer.send(map);
        connection.close();

    }


}

