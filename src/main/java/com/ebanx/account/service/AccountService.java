package com.ebanx.account.service;

import com.ebanx.account.exception.AccountNotFoundException;
import com.ebanx.account.model.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private static Map<String, Account> accounts = new HashMap<>();

    public Account getAccountById(String id) {
        return accounts.get(id);
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public BigDecimal getBalance(final String accountId) {
        var account = getAccountById(accountId);

        verifyAccount(account, accountId);

        return account.getBalance();
    }

    public void verifyAccount(final Account account, String accountId) {
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }
    }

    public void resetAccounts() {
        accounts = new HashMap<>();
    }

}
