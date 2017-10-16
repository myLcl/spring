package com.lcl.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DirectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "direct " + new Date();
		System.out.println("direct send ");
		this.rabbitTemplate.convertAndSend("directExchange","direct.message" ,context);
	}

}