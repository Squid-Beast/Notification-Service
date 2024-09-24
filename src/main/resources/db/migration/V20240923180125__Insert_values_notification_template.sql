INSERT INTO notification_template (category, notification_type, template) VALUES
(1, 'SMS', 'Your account has been locked due to multiple failed login attempts. Please reset your password.'),
(1, 'EMAIL', '<!DOCTYPE html>\n<html>\n<head>\n    <title>Password Update Notification</title>\n</head>\n<body>\n    <p>Dear {{accountNumber}},</p>\n    <p>Your password has been successfully updated.</p>\n    <p>If you did not request this change, please contact support.</p>\n    <p>Best regards.</p>\n</body>\n</html>'),
(1, 'APP', 'We noticed a login from a new location. If this was not you, please secure your account.'),
(2, 'SMS', 'Your mobile number has been successfully updated.'),
(2, 'EMAIL', '<!DOCTYPE html>\n<html>\n<head>\n    <title>Mobile Number Update</title>\n</head>\n<body>\n    <p>Dear {{accountNumber}},</p>\n    <p>Your mobile number has been updated successfully.</p>\n    <p>If you did not request this change, please contact support immediately.</p>\n    <p>Best regards.</p>\n</body>\n</html>'),
(2, 'APP', 'Your mobile number was updated successfully. If this was not you, please secure your account.'),
(3, 'SMS', 'You have successfully activated two-factor authentication (2FA) on your account.'),
(3, 'EMAIL', '<!DOCTYPE html>\n<html>\n<head>\n    <title>2FA Activation</title>\n</head>\n<body>\n    <p>Dear {{accountNumber}},</p>\n    <p>Two-factor authentication (2FA) has been activated for your account.</p>\n    <p>If you did not initiate this, please contact support immediately.</p>\n    <p>Best regards.</p>\n</body>\n</html>'),
(3, 'APP', 'Two-factor authentication has been enabled on your account. If you did not enable this, please contact support.');
