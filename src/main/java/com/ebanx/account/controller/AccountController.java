package com.ebanx.account.controller;

import com.ebanx.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    private AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/balance")
    public BigDecimal retrieveBalance(@RequestParam(value = "account_id") String accountId) {
        return accountService.getBalance(accountId);
    }

}
