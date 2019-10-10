package com.example.entity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    AmqpTemplate rabbitmqTemplate;

    public void send() {
        String content = "Sender says:" + "'hello， I'm sender'";
        System.out.println(content);
        rabbitmqTemplate.convertAndSend("hello", content);
    }
}
