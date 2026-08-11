package com.model;


public final class Transfer extends Transaction {

    private final String receiverAccount;

    public Transfer(double amount, String receiverAccount) {
        super(amount);
        this.receiverAccount = receiverAccount;
    }

    public String receiverAccount() {
        return receiverAccount;
    }
}