package com.example.customerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.customerapp.entity.Customer;
import com.example.customerapp.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }
}