package com.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct.A")
public class DirectReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver  : " + message);
    }
}
