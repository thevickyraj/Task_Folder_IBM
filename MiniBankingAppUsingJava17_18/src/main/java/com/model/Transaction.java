package com.model;

public sealed abstract class Transaction
        permits Credit, Debit, Transfer {

    private final double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public double amount() {
        return amount;
    }
}
