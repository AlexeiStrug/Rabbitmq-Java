package com.example.reabbtmqproducertwo;

import com.example.reabbtmq.model.InvoiceCancelledMessage;
import com.example.reabbtmqproducertwo.service.DummyProducer;
import com.example.reabbtmqproducertwo.service.InvoiceProducer;
import com.example.reabbtmqproducertwo.service.MultiplePrefetchProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ReabbtmqProducerTwoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReabbtmqProducerTwoApplication.class, args);
    }


    @Autowired
    private DummyProducer dummyProducer;

    @Autowired
    private MultiplePrefetchProducer multiplePrefetchProducer;

    @Autowired
    private InvoiceProducer invoiceProducer;

    @Override
    public void run(String... args) throws Exception {
//        for(int i = 0; i < 500; i++) {
//            var dummyMessage = new DummyMessage("test message", i);
//            dummyProducer.dummyMessage(dummyMessage);
//        }
//        multiplePrefetchProducer.simulateTransaction();
//        multiplePrefetchProducer.simulateScheduler();

//        var randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(100, 200);
//        var invoiceCreatedMessage = new InvoiceCreatedMessage(154.25, LocalDate.now(), "USD", randomInvoiceNumber);
//        invoiceProducer.sendInvoiceCreated(invoiceCreatedMessage);
//
//        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
//        var randomPaymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(20000, 30000);
//        var invoicePaidMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now(), randomPaymentNumber);
//        invoiceProducer.sendInvoicePaid(invoicePaidMessage);
//
//        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(300, 400);
//        var invoiceCanceledMessage = new InvoiceCancelledMessage(LocalDate.now(), randomInvoiceNumber, "Just cancel it");
//        invoiceProducer.sendInvoiceCanceled(invoiceCanceledMessage);
//
//        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(400, 500);
//        var invoiceRejectedMessage = new InvoiceRejectedMessage(LocalDate.now(), randomInvoiceNumber, "Just reject it");
//        invoiceProducer.sendInvoiceRejected(invoiceRejectedMessage);

        for (int i = 0; i < 10; i++) {
            var randomInvoiceNumber = "INV-" + i;
            var invoiceCanceledMessage = new InvoiceCancelledMessage(LocalDate.now(), randomInvoiceNumber, "Cancel invoice -> " + i);
            invoiceProducer.sendInvoiceCanceled(invoiceCanceledMessage);
        }
    }
}
