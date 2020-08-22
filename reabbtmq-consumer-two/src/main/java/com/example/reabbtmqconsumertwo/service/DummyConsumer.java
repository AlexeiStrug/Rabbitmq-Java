package com.example.reabbtmqconsumertwo.service;

import com.example.reabbtmq.model.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DummyConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DummyConsumer.class);

    @RabbitListener(queues = "q.dummy")
    public void listenDummy(DummyMessage message) {
        logger.info("Message: {}", message.toString());
    }
}
