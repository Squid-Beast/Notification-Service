package com.example.NotificationService.exception;

public class UserDetailsNotFoundException extends RuntimeException {
    public UserDetailsNotFoundException(String message) {
        super(message);
    }
}
