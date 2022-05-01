package com.ebanx.account.dto;

import com.ebanx.account.model.Account;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventOut {

    public EventOut() {
    }

    private Account origin;

    private Account destination;

    public void setDestination(final Account destination) {
        this.destination = destination;
    }

    public Account getDestination() {
        return destination;
    }

    public void setOrigin(final Account origin) {
        this.origin = origin;
    }

    public Account getOrigin() {
        return origin;
    }

}
