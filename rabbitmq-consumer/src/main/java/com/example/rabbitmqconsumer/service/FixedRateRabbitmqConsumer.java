package com.example.rabbitmqconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

//@Service
public class FixedRateRabbitmqConsumer {
    Logger logger = LoggerFactory.getLogger(FixedRateRabbitmqConsumer.class);

    @RabbitListener(queues = "queue.fixedrate", concurrency = "3")
    public void listen(String message) {
        logger.info("Got fixed rate - {} Thread - {} ", message, Thread.currentThread().getName());

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
