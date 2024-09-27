package com.example.NotificationService.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationPreferences {
    private String category;
    private boolean smsEnabled;
    private boolean appEnabled;
    private boolean emailEnabled;
}
