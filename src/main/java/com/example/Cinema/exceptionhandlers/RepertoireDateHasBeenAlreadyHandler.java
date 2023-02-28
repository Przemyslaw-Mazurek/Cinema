package com.example.Cinema.exceptionhandlers;

import com.example.Cinema.exceptions.ErrorResponse;
import com.example.Cinema.exceptions.RepertoireDateHasBeenAlready;
import com.example.Cinema.exceptions.RepertoireDateHasBeenAlready;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RepertoireDateHasBeenAlreadyHandler {

    @ExceptionHandler(RepertoireDateHasBeenAlready.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEmailAlreadyExistsException(RepertoireDateHasBeenAlready repertoireDateHasBeenAlready) {
        return new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                repertoireDateHasBeenAlready.getMessage()
        );
    }
}
