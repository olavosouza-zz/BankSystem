package com.ebanx.account.model;

import java.math.BigDecimal;

public class Account {

    private String id;

    private BigDecimal balance;

    public Account(final String id, final BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }

}
