package com.example.banking.service;

import com.example.banking.entity.Account;
import com.example.banking.repository.AccountRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Cacheable(value = "accounts", key = "#accountId")
    public Account getAccountDetails(Long accountId) {

        System.out.println("Fetching account from DATABASE...");

        return accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new RuntimeException("Account not found"));
    }

    @CachePut(value = "accounts", key = "#account.id")
    public Account updateAccount(Account account) {

        System.out.println("Updating account in DATABASE...");

        return accountRepository.save(account);
    }

    @CacheEvict(value = "accounts", key = "#accountId")
    public void deleteAccount(Long accountId) {

        System.out.println("Deleting account from DATABASE...");

        accountRepository.deleteById(accountId);
    }
}