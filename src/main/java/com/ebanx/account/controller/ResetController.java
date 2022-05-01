package com.ebanx.account.controller;

import com.ebanx.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResetController {

    private AccountService accountService;

    @Autowired
    private ResetController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/reset")
    public void resetAccounts() {
        accountService.resetAccounts();
    }

}
