package com.example.rabbitmqproducer.service;

import com.example.rabbitmqproducer.model.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Picture p) {
        try {
            var json = objectMapper.writeValueAsString(p);
            rabbitTemplate.convertAndSend("x.picture", p.getType(), json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
