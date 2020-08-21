package com.example.rabbitmqproducer;

import com.example.rabbitmqproducer.model.Employee;
import com.example.rabbitmqproducer.model.Picture;
import com.example.rabbitmqproducer.service.*;
import com.example.rabbitmqproducer.service.retry.RetryPictureProducer;
import com.example.rabbitmqproducer.service.retryspring.RetrySpringPictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

    @Autowired
    private HelloQueueMessageProducer helloQueueMessageProducer;

    @Autowired
    private EmployeeJsonProducer employeeJsonProducer;

    @Autowired
    private HrProducer hrProducer;

    @Autowired
    private PictureProducer pictureProducer;
    private final List<String> SOURCES = List.of("mobile", "web");
    private final List<String> TYPES = List.of("png", "jpg", "svg");

    @Autowired
    private PictureProducerTwo pictureProducerTwo;

    @Autowired
    private MyPictureProducer myPictureProducer;

    @Autowired
    private RetryPictureProducer retryPictureProducer;

    @Autowired
    private RetrySpringPictureProducer retrySpringPictureProducer;


    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        1
//        this.helloQueueMessageProducer.sendHello("Alex " + Math.random());
//        2
//        for (int i = 0; i < 5; i++) {
//            var e = new Employee("emp " + i, "Employee " + 1, LocalDate.now());
//            this.employeeJsonProducer.sendMessage(e);
//        }

//        for (int i = 0; i < 5; i++) {
//            var e = new Employee("emp " + i, "Employee " + 1, LocalDate.now());
//            this.hrProducer.sendMessage(e);
//        }

//        for (int i = 0; i < 10; i++) {
//            var p = new Picture();
//            p.setName("Picture " + i);
//            p.setSize(ThreadLocalRandom.current().nextLong(1, 10001));
//            p.setSource(SOURCES.get(i % SOURCES.size()));
//            p.setType(TYPES.get(i % TYPES.size()));
//
//            pictureProducerTwo.sendMessage(p);
//        }

//        for (int i = 0; i < 1; i++) {
//            var p = new Picture();
//            p.setName("Picture " + i);
//            p.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
//            p.setSource(SOURCES.get(i % SOURCES.size()));
//            p.setType(TYPES.get(i % TYPES.size()));
//
//            myPictureProducer.sendMessage(p);
//        }

        for (int i = 0; i < 1; i++) {
            var p = new Picture();
            p.setName("Picture " + i);
            p.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
            p.setSource(SOURCES.get(i % SOURCES.size()));
            p.setType(TYPES.get(i % TYPES.size()));

            retrySpringPictureProducer.sendMessage(p);
        }




    }
}
