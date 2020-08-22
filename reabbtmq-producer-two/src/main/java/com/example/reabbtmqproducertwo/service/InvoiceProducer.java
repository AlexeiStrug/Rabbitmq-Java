package com.example.reabbtmqproducertwo.service;

import com.example.reabbtmq.model.InvoiceCancelledMessage;
import com.example.reabbtmq.model.InvoiceCreatedMessage;
import com.example.reabbtmq.model.InvoicePaidMessage;
import com.example.reabbtmq.model.InvoiceRejectedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {

    private static final Logger log = LoggerFactory.getLogger(InvoiceProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "x.invoice";

    public void sendInvoiceCreated(InvoiceCreatedMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

    public void sendInvoicePaid(InvoicePaidMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

    public void sendInvoiceCanceled(InvoiceCancelledMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

    public void sendInvoiceRejected(InvoiceRejectedMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }




}
