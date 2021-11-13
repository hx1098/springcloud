package com.hx.consumerAndProductor;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.lang.reflect.Parameter;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/8 20:53
 * @description
 * @editUser hx
 * @editTime 2021/11/8 20:53
 * @editDescription  这里使用的是 手动指定消费分区, 但是会失去管理特定, 和负载均衡的特点
 */
public class KafkaConsumerQuickStart_2 {


    public static void main(String[] args) {
        //创建kafkaConsumer
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "node75:9092,node76:9092,node77:9092");
        //消费者需要进行反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //消费者的组信息
        /*properties.put(ConsumerConfig.GROUP_ID_CONFIG, "topic2");*/


        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

        List<TopicPartition> partitions = Arrays.asList(new TopicPartition("topic01", 1));
        //指定消费的位置
        kafkaConsumer.assign(partitions);
        //  todo 这里有点问题    从指定位置开始进行消费
        kafkaConsumer.seekToBeginning(partitions);
        //
        //kafkaConsumer.seek(new TopicPartition("topic01", 0), 1);


        //    2.订阅相关的Tipics
        kafkaConsumer.subscribe(Pattern.compile("^topic.*"));

    //    遍历消息
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(10));
            //如果取到了数据
            if (!consumerRecords.isEmpty()) {
                Iterator<ConsumerRecord<String, String>> recordIterator = consumerRecords.iterator();
                while (recordIterator.hasNext()) {
                    ConsumerRecord<String, String> record = recordIterator.next();

                    String topic = record.topic();
                    int partition = record.partition();//哪个分区的消息
                    long offset = record.offset();//在这个消息分区中的偏移量

                    String value = record.value();
                    String key = record.key();
                    long timestamp = record.timestamp();

                    System.out.println(topic + "\t" + "分区:"+partition + ", 偏移量:" + offset + ",key :" + key + ", value:" + value + ", timestamp:" + timestamp) ;
                }

            }
        }




    }
}
