package com.example.account.service;

import com.example.account.dto.CreateAccountRequest;
import com.example.account.exception.AccountNotFoundException;
import com.example.account.exception.InsufficientBalanceException;
import com.example.account.model.Account;
import com.example.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private static final SecureRandom RANDOM = new SecureRandom();

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account createAccount(CreateAccountRequest request) {
        Account account = new Account(
                request.getAccountHolderName(),
                generateAccountNumber(),
                request.getInitialBalance() == null ? BigDecimal.ZERO : request.getInitialBalance(),
                request.getAccountType()
        );
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with number: " + accountNumber));
    }

    @Transactional
    public Account credit(Long id, BigDecimal amount) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance().add(amount));
        return accountRepository.save(account);
    }

    @Transactional
    public Account debit(Long id, BigDecimal amount) {
        Account account = getAccountById(id);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException(
                    "Insufficient balance in account " + account.getAccountNumber() +
                            ". Available: " + account.getBalance() + ", requested: " + amount);
        }
        account.setBalance(account.getBalance().subtract(amount));
        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new AccountNotFoundException("Account not found with id: " + id);
        }
        accountRepository.deleteById(id);
    }

    private String generateAccountNumber() {
        String candidate;
        do {
            candidate = "AC" + (100000000 + RANDOM.nextInt(900000000));
        } while (accountRepository.existsByAccountNumber(candidate));
        return candidate;
    }
}
