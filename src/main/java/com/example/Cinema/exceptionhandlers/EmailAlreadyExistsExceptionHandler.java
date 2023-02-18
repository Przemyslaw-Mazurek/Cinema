package com.example.Cinema.exceptionhandlers;

import com.example.Cinema.exceptions.EmailAlreadyExistsException;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmailAlreadyExistsExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(emailAlreadyExistsException.getMessage());
    }
}
