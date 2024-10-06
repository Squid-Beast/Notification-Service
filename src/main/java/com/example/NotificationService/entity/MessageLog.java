package com.example.NotificationService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "message_log")
public class MessageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "service_provider")
    private String serviceProvider;
    @Column(name = "message_id")
    private String messageId;
    @Column(name = "recipient")
    private String recipient;
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private LocalDateTime createdTime = LocalDateTime.now();
    @Column(name = "retry_count")
    private int retryCount;

    public MessageLog(String serviceProvider, String messageId, String recipient, String content, String status, int retryCount) {
        this.serviceProvider = serviceProvider;
        this.messageId = messageId;
        this.recipient = recipient;
        this.content = content;
        this.status = status;
        this.retryCount = retryCount;
    }
    public MessageLog() {
    }
}
