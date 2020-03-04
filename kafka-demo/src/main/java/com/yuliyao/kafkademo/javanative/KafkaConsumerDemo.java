package com.yuliyao.kafkademo.javanative;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
public class KafkaConsumerDemo {

    private final String topic;

    private final KafkaConsumer kafkaConsumer;

    public KafkaConsumerDemo(String topic) {
        this.topic = topic;
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, "consumerClient");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.0.58:9082,10.0.0.59:9082,10.0.0.60:9082");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumerGroup2");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaConsumer = new KafkaConsumer(properties);
        kafkaConsumer.subscribe(Collections.singleton(topic));
    }

    public void poll() {
        ConsumerRecords<Integer,String> consumerRecords = kafkaConsumer.poll(1000);
        for (ConsumerRecord consumerRecord : consumerRecords) {
            System.out.println("message receive:" + consumerRecord.value());
        }

    }

    public static void main(String[] args) {
        KafkaConsumerDemo kafkaConsumerDemo = new KafkaConsumerDemo("test");
        while (true) {
            kafkaConsumerDemo.poll();
        }

    }
}
