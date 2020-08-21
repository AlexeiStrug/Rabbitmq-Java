package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.model.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class MyPictureImageConsumer {

    Logger logger = LoggerFactory.getLogger(MyPictureImageConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(Message message, Channel channel) {
        try {
            var p = objectMapper.readValue(message.getBody(), Picture.class);

            if (p.getSize() > 9000) {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//                throw new AmqpRejectAndDontRequeueException("Picture size is too large: " + p);
            }
            logger.info("On my image: {}", p.toString());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
