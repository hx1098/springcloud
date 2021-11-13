package com.hx.acks;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {
    public static void main(String[] args) {
        //1.创建链接参数
        Properties props=new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"node75:9092,node76:9092,node77:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        props.put(ProducerConfig.ACKS_CONFIG,"all");
        //重试次数, 不包含第一次发送的次数, 如果尝试发送三次, 失败, 则系统放弃发送,
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        //检测的超时时间.
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1);

        //2.创建生产者
        KafkaProducer<String,String> producer=new KafkaProducer<String, String>(props);

        //3.封账消息队列
            ProducerRecord<String, String> record = new ProducerRecord<>("topic01", "key acks", "acksvalue");
            producer.send(record);

        //因为再本地有缓存， 所以刷新缓存才行.
        producer.flush();

        producer.close();
    }
}
