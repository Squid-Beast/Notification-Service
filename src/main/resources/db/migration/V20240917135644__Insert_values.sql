INSERT INTO category (name, is_critical, is_deleted) VALUES
('ACCOUNT_LOCKED', TRUE, FALSE),
('PASSWORD_UPDATE', FALSE, FALSE),
('LOCATION_CHANGE', TRUE, FALSE);

INSERT INTO notification (notification_type, notification_template, category_id) VALUES
('SMS', 'Your account has been locked due to multiple failed login attempts. Please reset your password.', 1),
('E-mail', '<!DOCTYPE html>\n<html>\n<head>\n    <title>Password Update Notification</title>\n</head>\n<body>\n    <p>Dear {{accountNumber}},</p>\n    <p>Your password has been successfully updated.</p>\n    <p>If you did not request this change, please contact support.</p>\n    <p>Best regards.</p>\n</body>\n</html>', 2),
('App', 'We noticed a login from a new location. If this was not you, please secure your account.', 3);
