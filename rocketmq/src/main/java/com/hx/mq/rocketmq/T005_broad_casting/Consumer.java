package com.hx.mq.rocketmq.T005_broad_casting;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/6/13 20:21
 * @option
 * @description 广播消息, 与集群消息,如果一个consumer设置为集群, 一个consumer设置为广播模式, 会出问题的, 官方建议不要这么干<br>
 * 写代码的时候就应该解决此类问题, 而不是让框架去解决这个问题
 * @editUser hx
 * @editTime 2021/6/13 20:21
 * @editDescription
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group-001");
        consumer.setNamesrvAddr("192.168.190.132:9876");

        consumer.subscribe("xxoo-001", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
//        MessageModel.BROADCASTING : 广播消息   MessageModel.CLUSTERING : 集群消息, 默认为集群模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.start();
        System.out.println("start1....");
    }
}
