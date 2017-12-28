package com.iqmsoft.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class Sender {
	@Autowired
	RabbitMessagingTemplate template;

	@Bean
	Queue queue() {
		return new Queue("GreetQueue", false);
	}

	public void send(String message) {
		System.out.println("Sent message: " + message);
		template.convertAndSend("GreetQueue", message);
	}

}
