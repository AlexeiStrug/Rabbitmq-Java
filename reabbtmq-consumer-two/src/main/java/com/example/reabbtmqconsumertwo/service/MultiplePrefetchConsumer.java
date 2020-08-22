package com.example.reabbtmqconsumertwo.service;

import com.example.reabbtmq.model.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MultiplePrefetchConsumer {

    private static final Logger log = LoggerFactory.getLogger(MultiplePrefetchConsumer.class);

    @RabbitListener(queues = "q.transaction", concurrency = "2")
    public void listenTransaction(DummyMessage message) throws InterruptedException {
        log.info("Listen transaction : {}", message);
        Thread.sleep(100);
    }

    @RabbitListener(queues = "q.scheduler", concurrency = "2", containerFactory = "prefetchOneContainerFactory")
    public void listenScheduler(DummyMessage message) throws InterruptedException {
        log.info("Listen scheduler : {}", message);
        Thread.sleep(60000);
    }

}
