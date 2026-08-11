package com.bank.service;


import com.model.Customer;

public class BankService {

    public void displayCustomer(Customer customer) {
        System.out.println("Customer ID: " + customer.id());
        System.out.println("Customer Name: " + customer.name());
        System.out.println("Account Number: " + customer.accountNumber());
    }
}