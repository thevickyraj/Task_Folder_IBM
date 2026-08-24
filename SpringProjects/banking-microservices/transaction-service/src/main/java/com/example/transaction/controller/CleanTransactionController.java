package com.example.transaction.controller;

import com.example.transaction.dto.DepositRequest;
import com.example.transaction.dto.WithdrawRequest;
import com.example.transaction.dto.TransferRequest;
import com.example.transaction.model.Transaction;
import com.example.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CleanTransactionController {

    private final TransactionService transactionService;

    public CleanTransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(
            @RequestBody DepositRequest request) {

        return ResponseEntity.ok(
                transactionService.deposit(request)
        );
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(
            @RequestBody WithdrawRequest request) {

        return ResponseEntity.ok(
                transactionService.withdraw(request)
        );
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactions(
            @PathVariable Long accountId) {

        return ResponseEntity.ok(
                transactionService.getTransactionsForAccount(accountId)
        );
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(
            @RequestBody TransferRequest request) {

        return ResponseEntity.ok(
                transactionService.transfer(request)
        );
    }
}