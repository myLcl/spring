package com.lcl.rabbitmq.hello;

import com.lcl.rabbitmq.config.HelloRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by conglin.liu on 2017/10/16.
 */

@Component
@RabbitListener(queues = HelloRabbitConfig.queueName)
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2 : " + hello);

    }
}
