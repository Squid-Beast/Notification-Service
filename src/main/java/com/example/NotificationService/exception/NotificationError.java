package com.example.NotificationService.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationError {
    private String message;
    private Long errorCode;

    public NotificationError(String message, Long errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
