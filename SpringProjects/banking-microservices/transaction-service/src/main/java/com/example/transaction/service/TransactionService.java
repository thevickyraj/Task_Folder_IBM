package com.example.transaction.service;

import com.example.transaction.client.AccountClient;
import com.example.transaction.dto.DepositRequest;
import com.example.transaction.dto.TransferRequest;
import com.example.transaction.dto.WithdrawRequest;
import com.example.transaction.exception.AccountServiceException;
import com.example.transaction.exception.TransactionNotFoundException;
import com.example.transaction.model.Transaction;
import com.example.transaction.model.TransactionStatus;
import com.example.transaction.model.TransactionType;
import com.example.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public TransactionService(TransactionRepository transactionRepository, AccountClient accountClient) {
        this.transactionRepository = transactionRepository;
        this.accountClient = accountClient;
    }

    public Transaction deposit(DepositRequest request) {
        Transaction txn = new Transaction();
        txn.setToAccountId(request.getAccountId());
        txn.setAmount(request.getAmount());
        txn.setType(TransactionType.DEPOSIT);
        txn.setRemarks(request.getRemarks());

        try {
            accountClient.credit(request.getAccountId(), request.getAmount());
            txn.setStatus(TransactionStatus.SUCCESS);
        } catch (AccountServiceException e) {
            txn.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(txn);
            throw e;
        }
        return transactionRepository.save(txn);
    }

    public Transaction withdraw(WithdrawRequest request) {
        Transaction txn = new Transaction();
        txn.setFromAccountId(request.getAccountId());
        txn.setAmount(request.getAmount());
        txn.setType(TransactionType.WITHDRAWAL);
        txn.setRemarks(request.getRemarks());

        try {
            accountClient.debit(request.getAccountId(), request.getAmount());
            txn.setStatus(TransactionStatus.SUCCESS);
        } catch (AccountServiceException e) {
            txn.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(txn);
            throw e;
        }
        return transactionRepository.save(txn);
    }

    public Transaction transfer(TransferRequest request) {
        Transaction txn = new Transaction();
        txn.setFromAccountId(request.getFromAccountId());
        txn.setToAccountId(request.getToAccountId());
        txn.setAmount(request.getAmount());
        txn.setType(TransactionType.TRANSFER);
        txn.setRemarks(request.getRemarks());

        try {
            // Debit first; if it fails, nothing has moved yet.
            accountClient.debit(request.getFromAccountId(), request.getAmount());
            try {
                accountClient.credit(request.getToAccountId(), request.getAmount());
            } catch (AccountServiceException creditFailure) {
                // Compensating action: refund the sender since the credit leg failed.
                accountClient.credit(request.getFromAccountId(), request.getAmount());
                throw creditFailure;
            }
            txn.setStatus(TransactionStatus.SUCCESS);
        } catch (AccountServiceException e) {
            txn.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(txn);
            throw e;
        }
        return transactionRepository.save(txn);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id: " + id));
    }

    public List<Transaction> getTransactionsForAccount(Long accountId) {
        return transactionRepository.findByFromAccountIdOrToAccountId(accountId, accountId);
    }
}
