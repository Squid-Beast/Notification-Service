ALTER TABLE notification RENAME TO notification_template;

ALTER TABLE notification_template MODIFY notification_type ENUM('SMS', 'EMAIL', 'APP') NOT NULL;

ALTER TABLE notification_template CHANGE notification_template template TEXT NOT NULL;

DELETE FROM notification_template;

ALTER TABLE notification_template AUTO_INCREMENT = 1;
