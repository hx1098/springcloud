package com.hx.dml;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/8 20:17
 * @description
 * @editUser hx
 * @editTime 2021/11/8 20:17
 * @editDescription
 */
public class KafkaDML {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        /**这里是我的虚拟机的名称*/
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "node75:9092,node76:9092,node77:9092");
        KafkaAdminClient adminClient = (KafkaAdminClient) KafkaAdminClient.create(properties);

        //这种是异步的创建, 所以说他返回的时候偶是一个topic
        //adminClient.createTopics(Arrays.asList(new NewTopic("topic02", 3, (short) 3)));

        //同步创建的topic
     /*   CreateTopicsResult topic3 = adminClient.createTopics(Arrays.asList(new NewTopic("topic01", 3, (short) 3)));
        topic3.all().get();*/

        //查看kafka中有多少个topic,
      /*  ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> topicSet = listTopicsResult.names().get();
        for (String s : topicSet) {
            System.out.println(s);
        }*/

        //topic的删除
   /*     DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Arrays.asList("topic01"));
        deleteTopicsResult.all().get();*/



        DescribeTopicsResult topic01 = adminClient.describeTopics(Arrays.asList("topic01"));
        Map<String, TopicDescription> topic01Result = topic01.all().get();
        System.out.println("==========================");
        for (Map.Entry<String, TopicDescription> entry : topic01Result.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("==========================");

        //关闭
        adminClient.close();

    }

}
