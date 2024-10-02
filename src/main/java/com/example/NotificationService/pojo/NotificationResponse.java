package com.example.NotificationService.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResponse {
    private String status;

    public NotificationResponse(String status) {
        this.status = status;
    }
}
