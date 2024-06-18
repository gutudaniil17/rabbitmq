package com.rabbitmq.receiver2;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Receiver2Application {

    public static void main(String[] args) {
        SpringApplication.run(Receiver2Application.class, args);
    }

}
