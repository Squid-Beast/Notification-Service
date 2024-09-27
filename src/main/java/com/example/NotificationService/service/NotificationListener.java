//package com.example.NotificationService.service;
//
//import com.example.NotificationService.pojo.NotificationRequest;
//import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationListener {
//
//    @SqsListener("notification-queue")
//    public void receiveMessage(NotificationRequest message){
//        System.out.println(message);
//    }
//}
