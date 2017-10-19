package com.lcl.rabbitmq.topic;

import com.lcl.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send1() {
		String context = "hi, i am message 1" + new Date();
		System.out.println("Topic Sender" );
		rabbitTemplate.convertAndSend(TopicRabbitConfig.topicExchange, TopicRabbitConfig.routingKey, context);
	}

	public void send2() {
		String context = "hi, i am messages 2" + new Date();
		System.out.println("Topic Sender" );
		rabbitTemplate.convertAndSend(TopicRabbitConfig.topicExchange, TopicRabbitConfig.routingKey1, context);
	}

}