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


//        自动确认
//        手动确认的session 事物必须是false, 否则会抛异常
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination topic = session.createTopic("user");

        MessageProducer producer = session.createProducer(topic);

        Girl gril = new Girl("王麻子", "25", "398.0");


        ObjectMessage objectMessage = session.createObjectMessage(gril);
        producer.send(objectMessage);

//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

       /* for (int i = 0; i < 1000; i++) {
            
            TextMessage textMessage = session.createTextMessage("Hi, my name is hx" + i );
//            Thread.sleep(3000);

            *//*如果设置优先级的话, 就必须设置有优先级和没有优先级的*//*
            if(i%4==0){
                producer.send(textMessage,DeliveryMode.PERSISTENT,9,1000*100);
            }else{
                producer.send(textMessage);
            }

            *//*if(i%3 ==0) {
                //基於事物的commit
                session.commit();
            }
            if (i % 4==0){
                //理想條件下如果发生异常要回滚
                session.rollback();
            }*//*
        }*/

        connection.close();
        System.out.println("system exit.....");



    }

}