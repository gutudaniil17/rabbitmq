package com.rabbitmq.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class SendController {
    private final RabbitTemplate rabbitTemplate;
    private static Long counter = 0L;
    static final String exchangeName = "testExchange";

    @GetMapping("/ge1")
    public ResponseEntity<String> sendMessageToQ1(@RequestParam String message) {
        rabbitTemplate.convertAndSend(exchangeName,"first.key", message);
        log.info("Sent message: [{}], Count send object: [{}]", message, ++counter);
        return ResponseEntity.ok("Message sent to Q1");
    }

    @GetMapping("/ge2")
    public ResponseEntity<String> sendMessageToQ2(@RequestParam String message) {
        rabbitTemplate.convertAndSend(exchangeName,"second.key", message);
        log.info("Sent message: [{}], Count send object: [{}]", message, ++counter);
        return ResponseEntity.ok("Message sent to Q2");
    }
}
