package com.bank;

public class CreditCardPayment implements PaymentService {

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made using Credit Card.");
    }
}