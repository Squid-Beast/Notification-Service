package com.example.NotificationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserDetailsNotFoundException.class)
    public ResponseEntity<?> handleUserDetailsNotFoundException(UserDetailsNotFoundException userDetailsNotFoundException) {
        return new ResponseEntity<>("User details not found from external service.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException runtimeException) {
        return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return new ResponseEntity<>(new NotificationError("Notification Error.", 999L), HttpStatus.NOT_FOUND);
    }
}
