package com.example.Cinema.exceptionhandlers;

import com.example.Cinema.exceptions.EmailAlreadyExistsException;
import com.example.Cinema.exceptions.ErrorResponse;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class NoSuchElementFoundExceptionHandler {

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEmailAlreadyExistsException(NoSuchElementFoundException noSuchElementFoundException) {
        return new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                noSuchElementFoundException.getMessage()
        );
    }

}
