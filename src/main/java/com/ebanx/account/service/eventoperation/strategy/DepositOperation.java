package com.ebanx.account.service.eventoperation.strategy;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.dto.EventOut;
import com.ebanx.account.dto.TransactionOut;
import com.ebanx.account.enums.EventType;
import com.ebanx.account.model.Account;
import com.ebanx.account.service.AccountService;
import com.ebanx.account.service.eventoperation.EventOperation;
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
    public EventOut doOperation(EventIn eventIn) {
        var account = accountService.getAccountById(eventIn.getDestination());

        if (account == null) {
            account = createAccount(eventIn.getDestination(), eventIn.getAmount());
        } else {
            deposit(account, eventIn.getAmount());
        }

        return new TransactionOut(account.getId(), account.getBalance());
    }

    private void deposit(final Account account, final BigDecimal amountToOperate) {
        account.setBalance(account.getBalance().add(amountToOperate));
    }

    private Account createAccount(String accountId, BigDecimal depositAmount) {
        var account = new Account(accountId, depositAmount);
        accountService.addAccount(account);
        return account;
    }

}
