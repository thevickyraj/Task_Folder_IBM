package com.example.gateway.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{id}")
    public Map<String, Object> getDashboard(@PathVariable Long id) {

        // Call Account Service
        BigDecimal balance = restTemplate.getForObject(
                "http://localhost:8082/" + id + "/balance",
                BigDecimal.class
        );

        // Call Transaction Service
        List<?> transactions = restTemplate.getForObject(
                "http://localhost:8083/" + id,
                List.class
        );

        // Aggregate both responses
        return Map.of(
                "accountId", id,
                "balance", balance,
                "transactions", transactions
        );
    }
}