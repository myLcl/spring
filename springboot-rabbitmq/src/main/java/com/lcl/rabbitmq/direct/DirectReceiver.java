package com.lcl.rabbitmq.direct;

import com.lcl.rabbitmq.config.DirectRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = DirectRabbitConfig.directQueue)
public class DirectReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver  : " + message);
    }
}
