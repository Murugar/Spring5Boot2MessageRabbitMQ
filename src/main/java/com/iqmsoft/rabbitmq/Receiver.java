package com.iqmsoft.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
class Receiver {
	@RabbitListener(queues = "GreetQueue")
	public void processMessage(String content) {
		System.out.println("Recived message: " + content);
	}
}
