package com.hx.kafka.IMessage;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/21 13:43
 * @description
 * @editUser hx
 * @editTime 2021/11/21 13:43
 * @editDescription
 */
@Service
@Transactional
public class MessageSender implements IMessageSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String topic, String key, String message) {
        kafkaTemplate.send(new ProducerRecord<String, String>(topic, key, message));

    }
}
