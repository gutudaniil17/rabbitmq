package com.rabbitmq.receiver1;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Receiver1Application {
    static final String queueName = "firstQueue";
    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }


    @RabbitListener(queues = queueName)
    public void receive1(String message) {
        System.out.println("Received: " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(Receiver1Application.class, args);
    }

}
