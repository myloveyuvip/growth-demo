package com.yuliyao.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
@RestController
@RequestMapping("kafka")
public class kafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private String topic = "test";

    @GetMapping("send")
    public String send(String msg) {
        kafkaTemplate.send(topic, msg);
        return "success";
    }

}
