package com.example.NotificationService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notification_template")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "notification_type")
    private String notificationType;
    @Column(name = "template")
    private String notificationTemplate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
