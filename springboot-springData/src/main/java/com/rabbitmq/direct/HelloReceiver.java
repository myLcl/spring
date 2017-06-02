package com.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {

    @RabbitListener(queues = "queuetest2")
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
