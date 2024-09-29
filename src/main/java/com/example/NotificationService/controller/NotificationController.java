package com.example.NotificationService.controller;

import com.example.NotificationService.pojo.NotificationRequest;
import com.example.NotificationService.pojo.UserDetails;
import com.example.NotificationService.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notification")
@Slf4j
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public NotificationRequest createNotificationRequest(@RequestBody NotificationRequest requestDetails){
        log.info("Created notification request successfully.");
        return notificationService.sendNotification(requestDetails);
    }

    @GetMapping("/user/{userId}")
    public UserDetails getNotificationPreferences(@PathVariable Long userId) {
        log.info("Fetched notifications successfully.");
        return notificationService.getNotificationPreferences(userId);
    }
}
