package com.example.rabbitmqconsumer.service.retryspring;

import com.example.rabbitmqconsumer.model.Picture;
import com.example.rabbitmqconsumer.service.retry.RetryImageConsumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RetrySpringConsumer {

    private static final Logger log = LoggerFactory.getLogger(RetryImageConsumer.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.spring.image.work")
    public void listenImage(String msg) throws IOException {
        Picture p = null;
        try {
            p = objectMapper.readValue(msg, Picture.class);
            log.info("Consuming image: {}", p.getName());

            if (p.getSize() > 9000) {
                throw new IOException("Image " + p.getName() + " size too large : " + p.getSize());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("Pushing image: {}", p.getName());

    }

    @RabbitListener(queues = "q.spring.vector.work")
    public void listenVector(String msg) throws IOException {
        Picture p = null;
        try {
            p = objectMapper.readValue(msg, Picture.class);
            log.info("Consuming vector: {}", p.getName());

            if (p.getSize() > 9000) {
                throw new IOException("Image " + p.getName() + " size too large : " + p.getSize());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("Pushing vector: {}", p.getName());
    }
}
