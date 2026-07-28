package com.sql.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {

    @Autowired
    private com.example.demo.CustomerDAO customerDAO;

    @Override
    public void run(String... args) {

        customerDAO.selectAllRows();

    }
}