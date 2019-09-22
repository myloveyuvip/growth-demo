package com.yuliyao.kafkademo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"test-topic"})
    public void consumer(String message) {
        log.info("接收到消息：" + message);
    }

}
