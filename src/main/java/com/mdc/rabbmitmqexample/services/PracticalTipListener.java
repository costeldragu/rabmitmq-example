package com.mdc.rabbmitmqexample.services;

import com.mdc.rabbmitmqexample.RabbitMqExampleApplication;
import com.mdc.rabbmitmqexample.model.PracticalTipMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.mdc.rabbmitmqexample.RabbitMqExampleApplication.DEFAULT_PARSING_QUEUE;

@Service
public class PracticalTipListener {
    private static final Logger log = LoggerFactory.getLogger(PracticalTipListener.class);

    @RabbitListener(queues = DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage1(final Message<PracticalTipMessage> message) {
        log.info("consumeDefaultMessage1: Received message with default configuration: {}", message);

    }

    @RabbitListener(queues = DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage2(final Message<PracticalTipMessage> message) {
        log.info("consumeDefaultMessage2: Received message with default configuration: {}", message);

    }

    @RabbitListener(queues = DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage3(final Message<PracticalTipMessage> message) {
        log.info("consumeDefaultMessage3: Received message with default configuration: {}", message);

    }

}
