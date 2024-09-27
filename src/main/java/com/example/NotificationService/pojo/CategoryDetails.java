package com.example.NotificationService.pojo;

import com.example.NotificationService.entity.Notification;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDetails {
    private Long id;
    private String name;
    private boolean isCritical;
    private boolean isDeleted;
    private List<NotificationDetails> notificationTemplateList;
}
