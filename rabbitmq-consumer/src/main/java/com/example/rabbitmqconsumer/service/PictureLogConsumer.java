package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.model.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PictureLogConsumer {

    Logger logger = LoggerFactory.getLogger(PictureLogConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picture.log")
    public void listen(String message) {
        try {
            var p = objectMapper.readValue(message, Picture.class);
            logger.info("On log: {}", p.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
