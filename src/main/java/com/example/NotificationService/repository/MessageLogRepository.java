package com.example.NotificationService.repository;

import com.example.NotificationService.entity.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
    List<MessageLog> findByStatus(String status);
}
