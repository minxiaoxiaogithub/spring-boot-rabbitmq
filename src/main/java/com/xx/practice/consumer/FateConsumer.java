package com.xx.practice.consumer;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

import entity.Order;

@Component
public class FateConsumer {

  @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fate.queue", durable = "true"), 
      exchange = @Exchange(value = "fate.exchange", durable = "true", type = "topic"), key = "fate.night"))
  @RabbitHandler
  public void consumer(@Payload Order order, @Headers Map<String, Object> headers, Channel channel)
      throws IOException {
    System.out.println("=====开始消费信息=====");
    System.out.println(order.toString());
    long deliveryTag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
    channel.basicAck(deliveryTag, false);
    // channel.basicNack(deliveryTag, false, true);
    for (String key : headers.keySet()) {
      System.err.println("key:" + key + " value:" + headers.get(key).toString());
    }
  }
}
