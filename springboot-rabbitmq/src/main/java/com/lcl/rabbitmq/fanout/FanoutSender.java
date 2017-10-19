package com.lcl.rabbitmq.fanout;

import com.lcl.rabbitmq.config.FanoutRabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "fanout msg" + new Date();
		System.out.println("Fanout Sender");
		rabbitTemplate.convertAndSend(FanoutRabbitConfig.fanoutExchange,"", context);
	}

}