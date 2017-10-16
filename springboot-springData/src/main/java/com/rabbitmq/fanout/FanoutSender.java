package com.rabbitmq.fanout;

import com.rabbitmq.config.FanoutRabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "fanout msg ";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend(FanoutRabbitConfig.fanoutExchange,"", context);
	}

}