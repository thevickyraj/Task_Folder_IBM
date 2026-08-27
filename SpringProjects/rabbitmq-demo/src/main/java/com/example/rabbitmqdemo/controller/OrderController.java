package com.example.rabbitmqdemo.controller;

import com.example.rabbitmqdemo.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public String placeOrder(@RequestParam String order) {
        orderProducer.sendOrder(order);
        return "Order sent: " + order;
    }
}
