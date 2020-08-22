package com.example.reabbtmqproducertwo.service;

import com.example.reabbtmq.model.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void dummyMessage(DummyMessage message) {
        rabbitTemplate.convertAndSend("x.dummy", "", message);
    }
}
