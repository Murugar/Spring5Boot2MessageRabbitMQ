package com.iqmsoft.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

	@Autowired
	Sender sender;

	@GetMapping("/message/{msg}") // http://localhost:8080/message/World
	Greet greet(@PathVariable String msg) {
		sender.send("Hello -> " + msg);// Send to messaging node

		return new Greet("Hello -> " + msg);
	}

}
