package com.lrs.boot.amqp.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

public class SequenceSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Random random = new Random(29);

    @Scheduled(fixedDelay = 1000L)
    public void send(){
        rabbitTemplate.convertAndSend("sequence-queue","No" + random.nextInt(100));
    }
}
