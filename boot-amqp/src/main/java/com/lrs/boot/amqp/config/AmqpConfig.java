package com.lrs.boot.amqp.config;

import com.lrs.boot.amqp.sender.SequenceSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class AmqpConfig {

    @Bean
    public SequenceSender sender(){
        return  new SequenceSender();
    }

    @Bean
    public Queue sequenceQueue(){
        return new Queue("sequence-queue");
    }
}
