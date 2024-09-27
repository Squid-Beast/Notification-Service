package com.example.NotificationService.controller;

import com.example.NotificationService.pojo.NotificationRequest;
import com.example.NotificationService.pojo.UserDetails;
import com.example.NotificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public NotificationRequest createNotificationRequest(@RequestBody NotificationRequest requestDetails){
        return notificationService.sendNotification(requestDetails);
    }

    @GetMapping("/user/{userId}")
    public UserDetails getNotificationPreferences(@PathVariable Long userId) {
        return notificationService.getNotificationPreferences(userId);
    }
}
