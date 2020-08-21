package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.model.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PictureImageConsumer {

    Logger logger = LoggerFactory.getLogger(PictureImageConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picture.image")
    public void listen(String message) {
        try {
            var p = objectMapper.readValue(message, Picture.class);
            logger.info("On image: {}", p.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
