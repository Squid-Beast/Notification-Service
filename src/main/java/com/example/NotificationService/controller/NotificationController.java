package com.example.NotificationService.controller;

import com.example.NotificationService.pojo.NotificationRequest;
import com.example.NotificationService.pojo.NotificationResponse;
import com.example.NotificationService.pojo.UserDetails;
import com.example.NotificationService.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notification")
@Slf4j
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public ResponseEntity<NotificationResponse> createNotificationRequest(@RequestBody NotificationRequest requestDetails){
        log.info("Created notification request successfully.");
        NotificationResponse response = notificationService.sendNotification(requestDetails);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDetails> getNotificationPreferences(@PathVariable Long userId) {
        log.info("Fetched notifications successfully.");
        UserDetails userNotificationPreferences = notificationService.getNotificationPreferences(userId);
        return new ResponseEntity<>(userNotificationPreferences,HttpStatus.OK);
    }
}
