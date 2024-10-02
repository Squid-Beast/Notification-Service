package com.example.NotificationService.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageLogDetails {
    private Long id;
    private String serviceProvider;
    private String messageId;
    private String recipient;
    private String content;
    private String status;
    private LocalDateTime createdTime = LocalDateTime.now();
}
