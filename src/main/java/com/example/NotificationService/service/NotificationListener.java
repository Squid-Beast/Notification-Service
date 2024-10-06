package com.example.NotificationService.service;

import com.example.NotificationService.pojo.NotificationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationListener {

    @Autowired
    private NotificationService notificationService;

    @JmsListener(destination = "notification-request-queue")
    public void receiveMessage(String message) throws JsonProcessingException {
        log.info("Received Notification: {}",message);
        ObjectMapper objectMapper = new ObjectMapper();
        NotificationRequest request = objectMapper.readValue(message, NotificationRequest.class);
        notificationService.sendNotification(request);
    }
}
