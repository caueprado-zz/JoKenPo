package com.events.jokenpo.resource.controller;

import com.events.jokenpo.exception.ActionAlreadyExistsException;
import com.events.jokenpo.exception.ActionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ActionAlreadyExistsException.class)
    public ResponseEntity<String> actionAlreadyExistsExceptionHandler(final ActionAlreadyExistsException exception) {
        String errorMessages = "The action already exists in game context";
        return new ResponseEntity<>(errorMessages, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ActionNotFoundException.class)
    public ResponseEntity<String> actionNotFoundExceptionHandler(final ActionNotFoundException exception) {
        final String errorMessages = "This requests wants to perform a change in a non existent action";
        return new ResponseEntity<>(errorMessages, HttpStatus.NOT_FOUND);
    }
}
