CREATE TABLE message_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    service_provider VARCHAR(50),
    message_id VARCHAR(255),
    recipient VARCHAR(255),
    content TEXT,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    retry_count INT DEFAULT 0
);
