package com.example.reabbtmqconsumertwo.service;

import com.example.reabbtmq.model.InvoiceCancelledMessage;
import com.example.reabbtmq.model.InvoiceCreatedMessage;
import com.example.reabbtmq.model.InvoicePaidMessage;
import com.example.reabbtmq.model.PaymentCancelStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    private static final Logger log = LoggerFactory.getLogger(InvoiceConsumer.class);

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message) {
        log.info("on handleInvoiceCreated -> {}", message.toString());

    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message) {
        log.info("on handleInvoicePaid -> {}", message.toString());
    }

    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message) {
        log.info("on handleDefault -> {}", message);

    }

    @RabbitHandler
    @SendTo("x.invoice.cancel/")
    public PaymentCancelStatus handleInvoice(InvoiceCancelledMessage message) {
        var randomStatus = ThreadLocalRandom.current().nextBoolean();

        return new PaymentCancelStatus(randomStatus, LocalDate.now(), message.getInvoiceNumber());
    }
}
