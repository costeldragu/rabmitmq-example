package com.mdc.rabbmitmqexample.services;

import com.mdc.rabbmitmqexample.RabbitMqExampleApplication;
import com.mdc.rabbmitmqexample.model.PracticalTipMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.mdc.rabbmitmqexample.RabbitMqExampleApplication.EXCHANGE_NAME;
import static com.mdc.rabbmitmqexample.RabbitMqExampleApplication.ROUTING_KEY;

@Service
public class PracticalTipSender {

    private static final Logger log = LoggerFactory.getLogger(PracticalTipSender.class);

    private final RabbitTemplate rabbitTemplate;

    public PracticalTipSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendPracticalTip() {
        PracticalTipMessage tipMessage = new PracticalTipMessage("Always use Immutable clasees in Java", 1, false);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, tipMessage);
        log.info("Practical tip sent {}", tipMessage);
    }
}
