package com.bank;

import com.bank.service.BankService;
import com.bank.processor.TransactionProcessor;
import com.model.Credit;
import com.model.Customer;
import com.model.Debit;
import com.model.Transfer;

import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {

        Customer customer =
                new Customer(101, "Vicky", "BANK10001");

        BankService bankService = new BankService();

        bankService.displayCustomer(customer);

        System.out.println();

        TransactionProcessor processor =
                new TransactionProcessor();

        try (var executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            executor.submit(() ->
                    processor.process(new Credit(5000)));

            executor.submit(() ->
                    processor.process(new Debit(1500)));

            executor.submit(() ->
                    processor.process(
                            new Transfer(2000, "BANK20002")));
        }
    }
}