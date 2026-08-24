package com.example.account.controller;

import com.example.account.dto.BalanceUpdateRequest;
import com.example.account.dto.CreateAccountRequest;
import com.example.account.model.Account;
import com.example.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        Account created = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber));
    }

    @PutMapping("/{id}/credit")
    public ResponseEntity<Account> credit(@PathVariable Long id, @Valid @RequestBody BalanceUpdateRequest request) {
        return ResponseEntity.ok(accountService.credit(id, request.getAmount()));
    }

    @PutMapping("/{id}/debit")
    public ResponseEntity<Account> debit(@PathVariable Long id, @Valid @RequestBody BalanceUpdateRequest request) {
        return ResponseEntity.ok(accountService.debit(id, request.getAmount()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
