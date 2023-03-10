package com.example.Cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistsException extends ResponseStatusException {


    public EmailAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }

    public String getMessage() {
        return super.getReason();
    }
}
