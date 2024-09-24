CREATE TABLE category (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name ENUM('ACCOUNT_LOCKED', 'PASSWORD_UPDATE', 'LOCATION_CHANGE') NOT NULL,
    is_critical BOOLEAN NOT NULL,
    is_deleted BOOLEAN NOT NULL
);

CREATE TABLE notification (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    notification_type ENUM('SMS', 'E-mail', 'App') NOT NULL,
    notification_template TEXT NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);