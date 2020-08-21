package com.example.rabbitmqproducer.service;

import com.example.rabbitmqproducer.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Employee employee) {
        try {
            var json = objectMapper.writeValueAsString(employee);
            rabbitTemplate.convertAndSend("queue.employee", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
