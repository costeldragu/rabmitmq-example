package com.mdc.rabbmitmqexample;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMqExampleApplication {

	public static final String EXCHANGE_NAME = "tips_tx";
	public static final String DEFAULT_PARSING_QUEUE_1 = "default_parser_q_1";
	public static final String DEFAULT_PARSING_QUEUE_2 = "default_parser_q_2";
	public static final String DEFAULT_PARSING_QUEUE_3 = "default_parser_q_3";
	public static final String ROUTING_KEY = "tips";

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqExampleApplication.class, args);
	}

	@Bean
	public TopicExchange tipsExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue defaultParsingQueue1() {
		return new Queue(DEFAULT_PARSING_QUEUE_1);
	}

	@Bean
	public Queue defaultParsingQueue2() {
		return new Queue(DEFAULT_PARSING_QUEUE_2);
	}

	@Bean
	public Queue defaultParsingQueue3() {
		return new Queue(DEFAULT_PARSING_QUEUE_3);
	}

	@Bean
	public Binding queueToExchangeBinding1() {
		return BindingBuilder.bind(defaultParsingQueue1()).to(tipsExchange()).with(ROUTING_KEY);
	}

	@Bean
	public Binding queueToExchangeBinding2() {
		return BindingBuilder.bind(defaultParsingQueue2()).to(tipsExchange()).with(ROUTING_KEY);
	}

	@Bean
	public Binding queueToExchangeBinding3() {
		return BindingBuilder.bind(defaultParsingQueue3()).to(tipsExchange()).with(ROUTING_KEY);
	}

	@Bean
	public Jackson2JsonMessageConverter producerMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(producerMessageConverter());
		return template;
	}
}
