package com.bank.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BankingApp {

    public static void main(String[] args) {

        // 1. Streams + Lambda Expressions
        List<Transaction> transactions = Arrays.asList(
                new Transaction(500, LocalDate.now()),
                new Transaction(2500, LocalDate.now()),
                new Transaction(1200, LocalDate.now())
        );

        List<Transaction> highValue = transactions.stream()
                .filter(t -> t.getAmount() > 1000)
                .collect(Collectors.toList());

        highValue.forEach(
                t -> System.out.println("High Value Txn: " + t.getAmount())
        );

        // 2. Optional for Customer PAN
        Customer customer = new Customer("Ravi", null);

        customer.getPanCard().ifPresent(
                pan -> System.out.println("PAN: " + pan)
        );

        if (!customer.getPanCard().isPresent()) {
            System.out.println("PAN not available");
        }

        // 3. Date-Time API
        LocalDate today = LocalDate.now();
        LocalDate nextEmi = today.plusMonths(1);

        System.out.println("Next EMI due on: " + nextEmi);

        // 4. Default and Static Methods in Interface
        Payment payment = new CreditCardPayment();

        payment.validate();

        Payment.log("Payment processed successfully");

        // 5. Method Reference
        List<String> logs = Arrays.asList(
                "Debit",
                "Credit",
                "Transfer"
        );

        logs.forEach(System.out::println);
    }
}