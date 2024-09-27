CREATE TABLE category (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name ENUM('ACCOUNT_LOCKED', 'PASSWORD_UPDATE', 'LOCATION_CHANGE') NOT NULL,
    is_critical BOOLEAN NOT NULL,
    is_deleted BOOLEAN NOT NULL
);

CREATE TABLE notification_template (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id),
    notification_type ENUM('SMS', 'EMAIL', 'APP') NOT NULL,
    template TEXT NOT NULL
);