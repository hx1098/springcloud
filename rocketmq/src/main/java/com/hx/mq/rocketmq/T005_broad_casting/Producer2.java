package com.hx.mq.rocketmq.T005_broad_casting;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/6/13 17:12
 * @option
 * @description 异步消息
 * @editUser hx
 * @editTime 2021/6/13 17:12
 * @editDescription
 */
public class Producer2 {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group-001");


        producer.setNamesrvAddr("192.168.190.132:9876");
        producer.start();

        Message ms = new Message("xxoo-001","xxoo".getBytes());



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
