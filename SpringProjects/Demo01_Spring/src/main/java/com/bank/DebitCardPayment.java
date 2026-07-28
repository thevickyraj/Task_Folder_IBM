package com.bank;

public class DebitCardPayment implements PaymentService {

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made using Debit Card.");
    }
}