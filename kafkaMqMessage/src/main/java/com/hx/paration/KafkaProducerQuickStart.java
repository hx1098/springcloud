package com.hx.paration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/8 20:53
 * @description
 * @editUser hx
 * @editTime 2021/11/8 20:53
 * @editDescription
 */
public class KafkaProducerQuickStart {



    public static void main(String[] args) {
        //创建kafkaProducer
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "node75:9092,node76:9092,node77:9092");
        //序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  StringSerializer.class.getName());

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 30; i++) {
            ProducerRecord<String, String> topic01 = new ProducerRecord<>("topic01", "第" + i + "次 hello wrold");
            kafkaProducer.send(topic01);

        }

        kafkaProducer.close();

    }
}
