package com.ebanx.account.controller;

import com.ebanx.account.dto.EventIn;
import com.ebanx.account.service.OperationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EventController {

    private OperationFactory operationFactory;

    @Autowired
    private EventController(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    @PostMapping("/event")
    public void addEvent(@RequestBody @Valid EventIn eventIn) {
        operationFactory.getOperationByEvent(eventIn.getType()).doOperation(eventIn);
    }

}
