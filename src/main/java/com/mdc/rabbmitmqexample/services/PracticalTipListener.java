package com.mdc.rabbmitmqexample.services;

import com.mdc.rabbmitmqexample.model.PracticalTipMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.mdc.rabbmitmqexample.RabbitMqExampleApplication.DEFAULT_PARSING_QUEUE_2;
import static com.mdc.rabbmitmqexample.RabbitMqExampleApplication.DEFAULT_PARSING_QUEUE_3;
import static com.mdc.rabbmitmqexample.RabbitMqExampleApplication.DEFAULT_PARSING_QUEUE_1;

@Service
public class PracticalTipListener {
    private static final Logger log = LoggerFactory.getLogger(PracticalTipListener.class);

    @RabbitListener(queues = DEFAULT_PARSING_QUEUE_1)
    public void consumeDefaultMessage1(final PracticalTipMessage message) {
        log.info("consumeDefaultMessage1: Received message with default configuration: {}", message);

    }

    @RabbitListener(queues = DEFAULT_PARSING_QUEUE_2)
    public void consumeDefaultMessage2(final PracticalTipMessage message) {
        log.info("consumeDefaultMessage2: Received message with default configuration: {}", message);

    }

    @RabbitListener(queues = DEFAULT_PARSING_QUEUE_3)
    public void consumeDefaultMessage3(final PracticalTipMessage message) {
        log.info("consumeDefaultMessage3: Received message with default configuration: {}", message);

    }

}
