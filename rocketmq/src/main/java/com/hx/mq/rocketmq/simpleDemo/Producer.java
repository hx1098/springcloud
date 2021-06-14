package com.hx.mq.rocketmq.simpleDemo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/6/13 17:12
 * @option
 * @description
 * @editUser hx
 * @editTime 2021/6/13 17:12
 * @editDescription
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("xoxoGP");

//        设置namesever的地址;
        producer.setNamesrvAddr("192.168.190.132:9876");
        producer.start();
//        发送消息
//        topic 消息将要发送的地址
//        body  消息中将要发送的数据

        Message msg = new Message("myTopic001","第一条数据".getBytes());
        producer.send(msg);
        producer.shutdown();

    }

}
