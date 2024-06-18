package com.rabbitmq.receiver1;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Receiver1Application {
    static final String queueName = "firstQueue";
    static final String exchangeName = "testExchange";
    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    Exchange exchange(){
        return new TopicExchange(exchangeName, false, false);
    }
    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("first.key").noargs();
    }

    @RabbitListener(queues = queueName)
    public void receive1(String message) {
        System.out.println("Received: " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(Receiver1Application.class, args);
    }

}
