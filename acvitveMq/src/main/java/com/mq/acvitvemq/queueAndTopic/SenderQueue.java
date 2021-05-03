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


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("user");

        MessageProducer producer = session.createProducer(queue);

        MapMessage map = session.createMapMessage();
        map.setStringProperty("name", "zhangsan");
        map.setString("name", "zhangsan");
        map.setInt("age", 18);
        map.setIntProperty("age", 18);
        map.setDouble("price", 188);
        map.setDoubleProperty("price", 188);

        MapMessage map2 = session.createMapMessage();
        map2.setString("name", "lisi");
        map2.setStringProperty("name", "lisi");
        map2.setInt("age", 19);
        map2.setIntProperty("age", 19);
        map2.setDoubleProperty("price", 200);
        map2.setDouble("price", 200);

        MapMessage map3 = session.createMapMessage();
        map3.setString("name", "wangwu");
        map3.setStringProperty("name", "wangwu");
        map3.setInt("age", 20);
        map3.setIntProperty("age", 20);
        map3.setDoubleProperty("price", 300);
        map3.setDouble("price", 300);



        producer.send(map);
        producer.send(map2);
        producer.send(map3);
        connection.close();

    }


}

