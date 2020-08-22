package com.example.reabbtmqconsumertwo.service;

import com.example.reabbtmq.model.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DummyPrefetchConsumer {

    private static final Logger log = LoggerFactory.getLogger(DummyPrefetchConsumer.class);

    @RabbitListener(queues = "q.dummy", concurrency = "2")
    public void listenDummy(DummyMessage message) throws InterruptedException {
        log.info("Message is : {}", message);
        Thread.sleep(20000);
    }

}
