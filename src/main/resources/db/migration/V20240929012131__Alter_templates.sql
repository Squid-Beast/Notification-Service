-- Update password update email template
UPDATE notification_template
SET template = '<!DOCTYPE html>
               <html>
               <body>
                   <p>Dear {{accountNumber}},</p>
                   <p>We noticed that it has been some time since you last updated your password.</p>
                   <p>For your security, we strongly recommend updating your password at your earliest convenience. Regularly changing your password helps protect your account from unauthorized access.</p>
                   <p>Please visit your account settings to change your password. If you need assistance, feel free to reach out to our support team.</p>
                   <p>Thank you for prioritizing your account security.</p>
                   <p>Best regards,<br>The Security Team</p>
               </body>
               </html>'
WHERE id = 2 AND notification_type = 'EMAIL';

-- Update mobile number update email template
UPDATE notification_template
SET template = '<!DOCTYPE html>
                <html>
                <body>
                    <p>Dear {{accountNumber}},</p>
                    <p>Your mobile number has been successfully updated.</p>
                    <p>If you did not make this change, please contact our support team immediately. Keeping your account information up to date is crucial for your security.</p>
                    <p>If you need assistance or have any questions, feel free to reach out to us.</p>
                    <p>Thank you for using our services!</p>
                    <p>Best regards,<br>The Support Team</p>
                </body>
                </html>'
WHERE id = 5 AND notification_type = 'EMAIL';

-- Update two-factor authentication (2FA) email template
UPDATE notification_template
SET template = '<!DOCTYPE html>
                <html>
                <body>
                    <p>Dear {{accountNumber}},</p>
                    <p>You have requested a two-factor authentication (2FA) code to secure your account.</p>
                    <p>Your authentication code is: <strong>{{authCode}}</strong></p>
                    <p>Please enter this code to complete your login. This code is valid for a limited time, so please use it promptly.</p>
                    <p>If you did not request this code, please disregard this email and ensure your account remains secure.</p>
                    <p>Thank you for prioritizing your account security!</p>
                    <p>Best regards,<br>The Security Team</p>
                </body>
                </html>'
WHERE id = 8 AND notification_type = 'EMAIL';