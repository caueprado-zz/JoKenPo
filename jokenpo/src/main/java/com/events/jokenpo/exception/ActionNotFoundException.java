package com.events.jokenpo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Requested action not found")
public class ActionNotFoundException extends RuntimeException {
}
