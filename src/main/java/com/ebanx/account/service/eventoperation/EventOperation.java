package com.ebanx.account.service.eventoperation;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.dto.EventOut;
import com.ebanx.account.enums.EventType;

public interface EventOperation {

    EventType getEventType();

    EventOut doOperation(EventIn eventIn);

}
