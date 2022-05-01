package com.ebanx.account.service;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.enums.EventType;
import com.ebanx.account.model.Account;

public interface EventOperation {

    EventType getEventType();

    Account doOperation(EventIn eventIn);

}
