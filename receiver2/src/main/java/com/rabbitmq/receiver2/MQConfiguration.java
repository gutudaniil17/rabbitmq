package com.rabbitmq.receiver2;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfiguration {
    static final String queueName = "secondQueue";
    static final String exchangeName = "testExchange";

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }
    @Bean
    Exchange exchange() {
        return new TopicExchange(exchangeName, false, false);
    }

    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("second.key").noargs();
    }

    @RabbitListener(queues = queueName)
    public void receive(String message) {
        System.out.println("Received: " + message);
    }
}
