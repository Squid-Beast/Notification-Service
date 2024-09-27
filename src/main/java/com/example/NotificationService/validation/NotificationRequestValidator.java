package com.example.NotificationService.validation;

import com.example.NotificationService.pojo.NotificationRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class NotificationRequestValidator {
    public void validateNotificationRequest(NotificationRequest notificationRequest){
        if (notificationRequest.getUserId() == null){
            throw new RuntimeException("User-id should not be null.");
        }
        if (StringUtils.isEmpty(notificationRequest.getNotificationCategory())){
            throw new RuntimeException("Notification Category should not be null.");
        }
    }
}
