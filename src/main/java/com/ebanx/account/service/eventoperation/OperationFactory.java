package com.ebanx.account.service.eventoperation;

import com.ebanx.account.enums.EventType;
import com.ebanx.account.exception.StrategyNotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationFactory {

    private List<EventOperation> events;

    @Autowired
    private OperationFactory(List<EventOperation> events) {
        this.events = events;
    }

    public EventOperation getOperationByEvent(EventType eventType) {
        return events.stream()
            .filter(strategy -> strategy.getEventType() == eventType)
            .findFirst()
            .orElseThrow(() -> new StrategyNotImplementedException(eventType));
    }

}
