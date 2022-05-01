package com.ebanx.account.service.eventoperation.strategy;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.dto.EventOut;
import com.ebanx.account.enums.EventType;
import com.ebanx.account.service.AccountService;
import com.ebanx.account.service.eventoperation.EventOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TransferOperation implements EventOperation {

    private AccountService accountService;

    private WithdrawOperation withdrawOperation;

    private DepositOperation depositOperation;

    private TransferOperation(AccountService accountService, WithdrawOperation withdrawOperation, DepositOperation depositOperation) {
        this.accountService = accountService;
        this.withdrawOperation = withdrawOperation;
        this.depositOperation = depositOperation;
    }

    @Override
    public EventType getEventType() {
        return EventType.transfer;
    }

    @Override
    public ResponseEntity<EventOut> doOperation(final EventIn eventIn) {
        var maybeOriginAccount = accountService.getAccountById(eventIn.getOrigin());

        accountService.verifyAccount(maybeOriginAccount, eventIn.getOrigin());

        return null;
    }

}
