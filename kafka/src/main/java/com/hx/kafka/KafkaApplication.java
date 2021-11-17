package com.hx.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.handler.annotation.SendTo;

import java.io.IOException;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(KafkaApplication.class, args);
        System.in.read();
    }


    /**测试发送的*/
    @KafkaListeners(value = {@KafkaListener(topics = {"topic01"})})
    public void receive01(ConsumerRecord<String, String> record) {
        System.out.println("record:" + record);
    }


    /**测试从topic转发给topic03的数据*/
    @KafkaListeners(value = {@KafkaListener(topics = {"topic02"})})
    @SendTo(value = {"topic03"})
    public String receive02(ConsumerRecord<String, String> record) {
        System.out.println(record.value());
        return record.value() + "\t" + "hx heiha heiha";
    }

}
