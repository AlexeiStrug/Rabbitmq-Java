package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class AccountingConsumer {

    Logger logger = LoggerFactory.getLogger(AccountingConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.hr.accounting")
    public void listen(String message) {
        Employee emp = null;
        try {
            emp = objectMapper.readValue(message, Employee.class);
            logger.info("On Accounting, Employee is {}", emp);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
