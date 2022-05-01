package com.ebanx.account.dto;

import com.ebanx.account.enums.EventType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EventIn {

    public EventIn(String destination, BigDecimal amount) {
        this.destination = destination;
        this.amount = amount;
    }

    @NotNull
    private EventType type;

    private String destination;

    private String origin;

    @NotNull
    private BigDecimal amount;

    public EventType getType() {
        return type;
    }

    public void setType(final EventType type) {
        this.type = type;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

}
