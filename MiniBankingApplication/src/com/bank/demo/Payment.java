package com.bank.demo;

public interface Payment {

    // Default method
    default void validate() {
        System.out.println("Basic validation done.");
    }

    // Static method
    static void log(String msg) {
        System.out.println("LOG: " + msg);
    }
}