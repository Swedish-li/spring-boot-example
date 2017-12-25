package com.lrs.boot.amqp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@RabbitListener(queues = "sequence-queue")
@Configuration
public class SequenceListener {

    @RabbitHandler
    public void process(@Payload String seq){
        System.out.println(seq);
    }
}
