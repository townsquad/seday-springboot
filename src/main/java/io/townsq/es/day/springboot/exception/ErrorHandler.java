package io.townsq.es.day.springboot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(HttpStatusException.class)
    public ResponseEntity<ErrorMessage> handle(HttpStatusException exception) {
        ErrorMessage body = new ErrorMessage(exception.getMessage());
        return ResponseEntity.status(exception.getStatus()).body(body);
    }

}
