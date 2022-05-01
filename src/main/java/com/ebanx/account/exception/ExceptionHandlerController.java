package com.ebanx.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.math.BigDecimal;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({AccountNotFoundException.class})
    public ResponseEntity<BigDecimal> objectNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BigDecimal.ZERO);
    }

    @ExceptionHandler({StrategyNotImplementedException.class})
    public ResponseEntity<String> objectNotImplemented(StrategyNotImplementedException exception) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(exception.getMessage());
    }

    @ExceptionHandler({InsufficientFundsException.class})
    public ResponseEntity<String> insufficientFunds(InsufficientFundsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body   (exception.getMessage());
    }

}
