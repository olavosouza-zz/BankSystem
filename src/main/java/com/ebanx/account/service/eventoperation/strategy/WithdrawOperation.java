package com.ebanx.account.service.eventoperation.strategy;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.dto.EventOut;
import com.ebanx.account.dto.TransactionOut;
import com.ebanx.account.enums.EventType;
import com.ebanx.account.exception.InsufficientFundsException;
import com.ebanx.account.service.AccountService;
import com.ebanx.account.service.eventoperation.EventOperation;
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
    public EventOut doOperation(EventIn eventIn) {
        var account = accountService.getAccountById(eventIn.getDestination());

        accountService.verifyAccount(account, account.getId());

        var newBalance = newBalance(account.getBalance(), eventIn.getAmount());

        verifyBalance(newBalance, account.getId());

        account.setBalance(newBalance);

        return new TransactionOut(account.getId(), account.getBalance());
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
