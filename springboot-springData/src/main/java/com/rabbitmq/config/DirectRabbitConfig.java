package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by conglin.liu on 2017/6/2.
 */

@Configurable
public class DirectRabbitConfig {
    public static final String directQueue = "direct.A";
    public static final String directExchange = "directExchange";
    public static final String routingKey = "direct.message";

    @Bean
    public Queue AMessage() {
        return new Queue(directQueue);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchange);
    }

    @Bean
    Binding bindingExchangeMessage (Queue AMessage, DirectExchange directExchange) {
        return BindingBuilder.bind(AMessage).to(directExchange).with(routingKey);
    }


}