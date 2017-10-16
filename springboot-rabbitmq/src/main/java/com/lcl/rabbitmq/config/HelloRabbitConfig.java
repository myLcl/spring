package com.lcl.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by conglin.liu on 2017/10/16.
 */
@Configurable
public class HelloRabbitConfig {

    public static final String queueName = "helloQueue";


    @Bean
    public Queue queue() {
        return  new Queue(queueName);
    }
}
