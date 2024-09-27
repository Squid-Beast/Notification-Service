package com.example.NotificationService.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationRequest {
    private Long userId;
    private String notificationCategory;
    private List<String> notificationType;
    private Map<String,String> data;
}
