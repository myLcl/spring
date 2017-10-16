package com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {
    public static final String topicQueue = "topic.message";
    public static final String topicQueue1 = "topic.message1";

    public static final String topicExchange = "topicExchange";

    public static final String routingKey = "topic.message";
    public static final String routingKey1 = "topic.#";


    @Bean
    public Queue queueMessage() {
        return new Queue(topicQueue);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(topicQueue1);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(routingKey);
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with(routingKey1);
    }
}
