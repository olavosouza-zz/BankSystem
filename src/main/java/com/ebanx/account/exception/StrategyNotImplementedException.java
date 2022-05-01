package com.ebanx.account.exception;

import com.ebanx.account.enums.EventType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
public class StrategyNotImplementedException extends RuntimeException {

    public StrategyNotImplementedException(EventType eventType) {
        super("Strategy not implemented yet for operation: ".concat(eventType.name()));
    }

}
