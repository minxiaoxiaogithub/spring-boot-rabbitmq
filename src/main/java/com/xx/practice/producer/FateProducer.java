package com.xx.practice.producer;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Order;

@Component
public class FateProducer implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void send() {
    Order order = new Order();
    order.setId(1);
    order.setName("订单1");
    order.setMessageId(UUID.randomUUID().toString());
    CorrelationData correlationData = new CorrelationData();
    correlationData.setId(order.getMessageId());
    rabbitTemplate.setConfirmCallback(this);
    rabbitTemplate.setReturnCallback(this);
    // rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
    // @Override
    // public void confirm(CorrelationData correlationData, boolean ack, String cause) {
    // if (!ack) {
    // System.err.println("消息唯一标识：" + correlationData);
    // System.err.println("确认结果：" + ack);
    // System.err.println("失败原因：" + cause);
    // } else {
    // System.err.println("FateProducer消息发送成功 ");
    // }
    // }
    // });
    rabbitTemplate.convertAndSend("fate.exchange", "fate.night", order, correlationData);
  }

  @Override
  public void returnedMessage(Message message, int replyCode, String replyText, String exchange,
      String routingKey) {
    System.err.println("ReturnCallback触发！");
    System.err.println("Message: " + message.toString());
    System.err.println("replyText: " + replyText);
    System.err.println("exchange: " + exchange);
    System.err.println("routingKey: " + routingKey);
  }

  @Override
  public void confirm(CorrelationData correlationData, boolean ack, String cause) {
    System.err.println("ConfirmCallback触发！");
    if (!ack) {
      System.err.println("消息唯一标识：" + correlationData);
      System.err.println("确认结果：" + ack);
      System.err.println("失败原因：" + cause);
    } else {
      System.err.println("FateProducer消息发送成功 ");
    }
  }

}
