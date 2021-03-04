package com.example.emailsending.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "email send failed")
public class EmailSendException extends RuntimeException {
    public EmailSendException() {
        super("sending error");
    }
}
