package com.mq.acvitvemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author hx
 * @createTime 2021/5/1 15:26
 * @option
 * @description 消息接收
 */
public class Receiver {

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


//       获取消息
        MessageConsumer consumer = session.createConsumer(queue);
        for (int i = 0; ;i++ ) {
            TextMessage receive = (TextMessage) consumer.receive();
            System.out.println("message" + receive.getText());
            /*receive.acknowledge();*/

            //每四条提交一次
           /* if(i%4==0){
                session.commit();
            }*/
        }


    }


}
