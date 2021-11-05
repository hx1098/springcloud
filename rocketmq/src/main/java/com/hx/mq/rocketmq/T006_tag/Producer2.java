package com.hx.mq.rocketmq.T006_tag;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/7/16 7:11
 * @option
 * @description 消息过滤
 * @editUser hx
 * @editTime 2021/7/16 7:11
 * @editDescription
 *
 *  tag可以将消息进行过滤,不同的消费者可以订阅一个topic, 但是可以指定特定的tag标签.
 */
public class Producer2 {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group-002");


        producer.setNamesrvAddr("192.168.190.132:9876");
        producer.start();

//        tag 其实就是标签的意思

        Message ms = new Message("xxoo-002","TAG-002","KEY-CHOUBAOER","xxoo-002-tag002发送的消息".getBytes());

        producer.send(ms, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功!");
                System.out.println("sendResult" + sendResult);
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
                System.out.println("发送异常!");
            }
        });



//        producer.shutdown();
        System.out.println("已经停机.....");

    }
}
