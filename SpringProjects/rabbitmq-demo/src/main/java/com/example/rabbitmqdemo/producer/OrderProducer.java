package com.example.rabbitmqdemo.producer;

import com.example.rabbitmqdemo.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendOrder(String order) {
        amqpTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, order);
        System.out.println("Sent: " + order);
    }
}
