package com.example.rabbitmqconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class HelloRabbitmqConsumer {

    @RabbitListener(queues = "queue.hello")
    public void listen(String message) {
        System.out.println("Got - " + message);
    }
}
