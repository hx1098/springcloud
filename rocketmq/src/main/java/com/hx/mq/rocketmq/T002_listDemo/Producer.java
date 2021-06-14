package com.hx.mq.rocketmq.T002_listDemo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

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

        List<Message> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Message message = new Message("xxoo-001", ("我发送了" + i + "条消息").getBytes());
            list.add(message);
        }
        SendResult send = producer.send(list);
        System.out.println(send);
        producer.shutdown();
        System.out.println("已经停机.....");

    }
}
