package com.hx.mq.rocketmq.T003_NoSyncMeeeage;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

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
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("xoxoGP");

//        设置namesever的地址;
        producer.setNamesrvAddr("192.168.190.132:9876");
        producer.start();
//      异步可靠消息,
//      不会阻塞,等待broker的确认,采用事件监听方式接受broker返回的确认
//        producer.setRetryTimesWhenSendAsyncFailed();
        Message ms = new Message("xxoo-001","xxoo".getBytes());

        producer.send(ms, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功!.........");
                System.out.println("sendResult：　" + sendResult);
            }

            @Override
            public void onException(Throwable e) {
//                如果发生异常,case异常,尝试重投,
//                或者调整业务逻辑
                System.out.println("发生异常");
                e.printStackTrace();
            }
        });



        producer.shutdown();
        System.out.println("已经停机.....");

    }
}
