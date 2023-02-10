package com.example.Cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchElementFoundException extends ResponseStatusException {

    private String message;

    public NoSuchElementFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public String getMessage() {
        return message;
    }
}
