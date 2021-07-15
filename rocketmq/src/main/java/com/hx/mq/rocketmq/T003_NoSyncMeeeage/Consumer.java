package com.hx.mq.rocketmq.T003_NoSyncMeeeage;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/6/13 20:21
 * @option
 * @description 异步消息
 * @editUser hx
 * @editTime 2021/6/13 20:21
 * @editDescription
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("xoxoGP");
        consumer.setNamesrvAddr("192.168.190.132:9876");

//        每一个consumer关注一个topic
//        过滤器表示不过滤
        consumer.subscribe("xxoo-001", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
//                默认情况下,这条消息只会被一个consumer  消息到点对点
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("start....");
    }
}
