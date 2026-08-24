package com.example.account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class BalanceUpdateRequest {

    @NotNull
    @Positive(message = "amount must be greater than zero")
    private BigDecimal amount;

    public BalanceUpdateRequest() {
    }

    public BalanceUpdateRequest(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
