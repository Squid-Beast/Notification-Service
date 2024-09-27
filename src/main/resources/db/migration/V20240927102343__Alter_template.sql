-- V20240928120000__Update_notification_templates.sql

-- Update the Password Update Notification template
UPDATE notification_template
SET template = '<!DOCTYPE html>
<html>
<head>
    <title>Password Update Notification</title>
</head>
<body>
    <p>Dear {{accountNumber}},</p>
    <p>It has been a long time since you last changed your password.</p>
    <p>For your security, we recommend that you update your password at your earliest convenience. Please visit your account settings to change your password.</p>
    <p>Best regards.</p>
</body>
</html>',
    subject = 'Action Required: Password Update Notification'
WHERE id = 2 AND notification_type = 'EMAIL';

-- Update the Mobile Number Update Notification template
UPDATE notification_template
SET template = '<!DOCTYPE html>
<html>
<head>
    <title>Mobile Number Update Notification</title>
</head>
<body>
    <p>Dear {{accountNumber}},</p>
    <p>Your mobile number has been successfully updated in our records.</p>
    <p>If you did not request this change, please contact support immediately.</p>
    <p>Best regards.</p>
</body>
</html>',
    subject = 'Action Required: Mobile Number Update'
WHERE id = 5 AND notification_type = 'EMAIL';

-- Update the 2FA Activation Notification template
UPDATE notification_template
SET template = '<!DOCTYPE html>
<html>
<head>
    <title>2FA Activation</title>
</head>
<body>
    <p>Dear {{accountNumber}},</p>
    <p>Two-factor authentication (2FA) has been activated for your account. You have received a new notification in your app.</p>
    <p>Please open the app to view the details.</p>
    <p>Best regards.</p>
</body>
</html>',
    subject = 'Immediate Action Required: Account Locked'
WHERE id = 8 AND notification_type = 'EMAIL';
