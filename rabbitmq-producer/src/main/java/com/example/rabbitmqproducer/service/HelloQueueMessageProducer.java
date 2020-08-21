package com.example.rabbitmqproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloQueueMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHello(String msg) {
        this.rabbitTemplate.convertAndSend("queue.hello", "Hello " + msg);
    }
}
