package com.example.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/account")
    public ResponseEntity<Map<String, Object>> accountFallback() {
        return response("account-service");
    }

    @GetMapping("/transaction")
    public ResponseEntity<Map<String, Object>> transactionFallback() {
        return response("transaction-service");
    }

    private ResponseEntity<Map<String, Object>> response(String service) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "timestamp", Instant.now().toString(),
                        "service", service,
                        "message", service + " is currently unavailable. Please try again later."
                ));
    }
}
