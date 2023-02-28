package com.example.Cinema.exceptionhandlers;

import com.example.Cinema.exceptions.EmailAlreadyExistsException;
import com.example.Cinema.exceptions.ErrorResponse;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class EmailAlreadyExistsExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException) {
        return new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                emailAlreadyExistsException.getMessage()
        );
    }
}
