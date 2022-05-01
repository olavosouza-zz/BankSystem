package com.ebanx.account.service;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.enums.EventType;
import com.ebanx.account.exception.AccountNotFoundException;
import com.ebanx.account.exception.InsufficientFundsException;
import com.ebanx.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WithdrawOperation implements EventOperation {

    private AccountService accountService;

    @Autowired
    private WithdrawOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public EventType getEventType() {
        return EventType.withdraw;
    }

    @Override
    public Account doOperation(EventIn eventIn) {
        var account = accountService.getAccountById(eventIn.getDestination());

        verifyAccount(account, account.getId());

        var newBalance = newBalance(account.getBalance(), eventIn.getAmount());

        verifyBalance(newBalance, account.getId());

        account.setBalance(newBalance);

        return account;
    }

    private void verifyAccount(final Account account, String accountId) {
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }
    }

    private void verifyBalance(BigDecimal newBalance, String id) {
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException(id);
        }
    }

    private BigDecimal newBalance(BigDecimal balance, BigDecimal amountToWithdraw) {
        return balance.subtract(amountToWithdraw);
    }

}
