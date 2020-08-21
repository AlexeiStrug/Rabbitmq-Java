package com.example.rabbitmqproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class FixedRateQueueMessageProducer {
    Logger logger = LoggerFactory.getLogger(FixedRateQueueMessageProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private int count = 0;

    @Scheduled(fixedRate = 500)
    public void sendMessageFixedRate() {
        count++;
        logger.info("Count is " + count);
        rabbitTemplate.convertAndSend("queue.fixedrate", "Message rate is " + count);

    }
}
