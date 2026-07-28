package com.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderService orderService =
                context.getBean("orderService", OrderService.class);

        orderService.placeOrder(250.00);
    }
}