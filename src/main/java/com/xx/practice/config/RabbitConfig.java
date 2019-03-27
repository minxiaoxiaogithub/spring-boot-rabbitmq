package com.xx.practice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

//  @Bean
//  public Queue saberQueue() {
//    return new Queue("saberQueue");
//  }
//
//  @Bean
//  public Queue archerQueue() {
//    return new Queue("archerQueue");
//  }
//
//  @Bean
//  public TopicExchange fateExchange() {
//    return new TopicExchange("fateExchange");
//  }
//
//  @Bean
//  public Binding bindingSaberExchange(Queue saberQueue, TopicExchange fateExchange) {
//    return BindingBuilder.bind(saberQueue).to(fateExchange).with("fate.saber");
//  }
//
//  @Bean
//  public Binding bindingArcherExchange(Queue archerQueue, TopicExchange fateExchange) {
//    return BindingBuilder.bind(archerQueue).to(fateExchange).with("fate.archer");
//  }

}
