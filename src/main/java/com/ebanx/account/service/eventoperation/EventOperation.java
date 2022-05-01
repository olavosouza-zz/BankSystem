package com.ebanx.account.service.eventoperation;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.dto.EventOut;
import com.ebanx.account.enums.EventType;
import org.springframework.http.ResponseEntity;

public interface EventOperation {

    EventType getEventType();

    ResponseEntity<EventOut> doOperation(EventIn eventIn);

}
