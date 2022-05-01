package com.ebanx.account.controller;

import com.ebanx.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ResetController {

    private AccountService accountService;

    @Autowired
    private ResetController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/reset")
    public void resetAccounts() {
        accountService.resetAccounts();
    }

}
