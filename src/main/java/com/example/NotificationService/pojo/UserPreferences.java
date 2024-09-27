package com.example.NotificationService.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPreferences {
    private boolean disableAllNotifications;
    private boolean criticalNotificationOnly;
    private List<NotificationPreferences> notificationPreferences;
}
