package com.rabbitmq.hello;

import com.rabbitmq.config.HelloRabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by conglin.liu on 2017/10/16.
 */

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "helloQueue " + new Date();
        System.out.println("Send from hello");
        amqpTemplate.convertAndSend(HelloRabbitConfig.queueName,context);
    }

}
