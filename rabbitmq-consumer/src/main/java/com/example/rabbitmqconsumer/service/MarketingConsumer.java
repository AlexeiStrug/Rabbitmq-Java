package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class MarketingConsumer {

    Logger logger = LoggerFactory.getLogger(MarketingConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.hr.marketing")
    public void listen(String message) {
        Employee emp = null;
        try {
            emp = objectMapper.readValue(message, Employee.class);
            logger.info("On Marketing, Employee is {}", emp);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
