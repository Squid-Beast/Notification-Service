package com.example.NotificationService.service;

import com.example.NotificationService.pojo.NotificationRequestDetails;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @SqsListener("notification-queue")
    public void receiveMessage(NotificationRequestDetails message){
        System.out.println(message);
    }
}
