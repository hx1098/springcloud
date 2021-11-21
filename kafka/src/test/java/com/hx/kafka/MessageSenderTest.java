package com.hx.kafka;

import com.hx.kafka.IMessage.IMessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/21 13:48
 * @description
 * @editUser hx
 * @editTime 2021/11/21 13:48
 * @editDescription
 */
@SpringBootTest(classes = KafkaApplication.class)
@RunWith(SpringRunner.class)
public class MessageSenderTest {


    @Autowired
    private IMessageSender messageSender;

    @Test
    public void testSenderMessage1() {
        messageSender.sendMessage("topic02", "003", "this is IMessageSender#testSendMessage");

    }
}
