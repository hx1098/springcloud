package com.hx.mq.rocketmq.T007_TCC;

import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.cglib.proxy.Enhancer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
        TransactionMQProducer producer = new TransactionMQProducer("group-tran");

        producer.setNamesrvAddr("192.168.190.132:9876");


        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
//               执行恩地事物
                System.out.println("=========executeLocalTransaction :");
                System.out.println("=========executeLocalTransaction :" + msg.getBody());
                System.out.println("=========executeLocalTransaction :" + msg.getTransactionId());

                return LocalTransactionState.UNKNOW;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
//                Borker端斤西瓜回调,
                System.out.println("=========checkLocalTransaction :");
                System.out.println("=========checkLocalTransaction :" + new String(msg.getBody()));
                System.out.println("=========checkLocalTransaction :" + msg.getTransactionId());
                System.out.println(LocalDateTime.now());

                return LocalTransactionState.UNKNOW;
            }
        });


        producer.start();
        TransactionSendResult tranResult = producer.sendMessageInTransaction(new Message("xxoo-002", "事物消息--测试".getBytes()), null);

        System.out.println("tranResult:" + tranResult);


        //producer.shutdown();
        System.out.println("已经停机.....");

        CountDownLatch latch = new CountDownLatch(2);
        //Semaphore

    }
}
