package com.yuliyao.kafkademo.javanative;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
public class KafkaProducerDemo {

    private final String topic;

    private final KafkaProducer kafkaProducer;

    public KafkaProducerDemo(String topic) {
        this.topic = topic;
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.0.58:9082,10.0.0.59:9082,10.0.0.60:9082");
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "-1");
        properties.setProperty(ProducerConfig.CLIENT_ID_CONFIG, "ProducerClient");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        this.kafkaProducer = new KafkaProducer(properties);
    }

    public void sent() {
        for (int i = 0; i < 50000000; i++) {
            ProducerRecord producerRecord = new ProducerRecord(topic, null, "message" + i);
            try {
                Object o = kafkaProducer.send(producerRecord).get();
                System.out.println("发送消息：" + o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        KafkaProducerDemo kafkaProducerDemo = new KafkaProducerDemo("test-part");
        kafkaProducerDemo.sent();
    }
}
