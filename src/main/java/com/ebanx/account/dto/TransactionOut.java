package com.ebanx.account.dto;

import java.math.BigDecimal;

public class TransactionOut implements EventOut{

    public TransactionOut(String id, BigDecimal balance) {
        this.balance = balance;
        this.id = id;
    }

    private String id;

    private BigDecimal balance;

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }

    public void setId(final String id) {
        this.id = id;
    }

}
