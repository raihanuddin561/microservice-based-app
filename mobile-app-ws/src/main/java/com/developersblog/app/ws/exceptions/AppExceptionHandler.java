package com.developersblog.app.ws.exceptions;

import org.springframework.http.HttpHeaders;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(
            Exception ex, WebRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(new Date())
                .message(ex.getLocalizedMessage())
                .build();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(),
                INTERNAL_SERVER_ERROR);
    }
}
