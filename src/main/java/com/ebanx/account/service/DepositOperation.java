package com.ebanx.account.service;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.enums.EventType;
import com.ebanx.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DepositOperation implements EventOperation {

    private AccountService accountService;

    @Autowired
    private DepositOperation(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public EventType getEventType() {
        return EventType.deposit;
    }

    @Override
    public Account doOperation(EventIn eventIn) {
        var account = accountService.getAccountById(eventIn.getDestination());

        if (account == null) {
            createAccount(eventIn.getDestination(), eventIn.getAmount());
        } else {
            deposit(account, eventIn.getAmount());
        }

        return null;
    }

    private void deposit(final Account account, final BigDecimal amountToOperate) {
        account.setBalance(account.getBalance().add(amountToOperate));
    }

    private void createAccount(String accountId, BigDecimal depositAmount) {
        accountService.addAccount(new Account(accountId, depositAmount));
    }

}
