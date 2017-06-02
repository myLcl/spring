package com.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import javax.management.Query;

/**
 * Created by conglin.liu on 2017/6/2.
 */

@Configurable
public class RabbitDirectConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("queuetest2");
    }
}