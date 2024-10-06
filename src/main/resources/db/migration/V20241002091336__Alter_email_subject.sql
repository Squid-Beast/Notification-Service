UPDATE notification_template
SET subject = 'Immediate Action Required: Account Locked'
WHERE id = 2 AND notification_type = 'EMAIL';

UPDATE notification_template
SET subject = 'Action Required: Password Update Notification'
WHERE id = 5 AND notification_type = 'EMAIL';

UPDATE notification_template
SET subject = 'Action Required: New Location Detected'
WHERE id = 8 AND notification_type = 'EMAIL';

UPDATE notification_template
SET template = 'Your account has been temporarily locked due to multiple unsuccessful login attempts. If this was you, no further action is required.'
WHERE id = 3 AND notification_type = 'APP';

UPDATE notification_template
SET template = 'We noticed a login attempt from a new location. If this was you, no further action is required.'
WHERE id = 9 AND notification_type = 'APP';

UPDATE notification_template
SET template = 'Your password is expiring soon. Please update your password.'
WHERE id = 6 AND notification_type = 'APP';

UPDATE notification_template
SET template = 'Your password is expiring soon. Please update your password.'
WHERE id = 4 AND notification_type = 'SMS';

UPDATE notification_template
SET template = 'New login detected. If this is not you, secure your account.'
WHERE id = 7 AND notification_type = 'SMS';