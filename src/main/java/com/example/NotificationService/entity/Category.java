package com.example.NotificationService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "is_critical")
    private boolean isCritical;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @OneToMany(mappedBy = "category")
    private List<Notification> notificationTemplateList;
}
