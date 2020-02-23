package com.mdc.rabbmitmqexample.services;

import com.mdc.rabbmitmqexample.RabbitMqExampleApplication;
import com.mdc.rabbmitmqexample.model.PracticalTipMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PracticalTipListener {
    private static final Logger log = LoggerFactory.getLogger(PracticalTipListener.class);

    @RabbitListener(queues = RabbitMqExampleApplication.DEFAULT_PARSOMG_QUEUE)
    public void consumeDefaultMEssage(final Message<PracticalTipMessage> message) {
        log.info("Received message with default configuration: {}", message);

    }

}
