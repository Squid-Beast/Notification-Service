UPDATE notification_template
SET template = '<!DOCTYPE html>
                <html>
                <body>
                  <p>Dear {{accountNumber}},</p>
                  <p>We regret to inform you that your account has been locked due to multiple failed login attempts. This is a security measure to protect your account.</p>
                  <p>If you believe this is an error, or if you need help regaining access to your account. Please contact support.</p>
                  <p>Thank you for your understanding.</p>
                  <p>Sincerely,</p>
                  <p>The Support Team</p>
                </body>
                </html>'
WHERE id = 2 AND notification_type = 'EMAIL';

UPDATE notification_template
SET template = '<!DOCTYPE html>
                <html>
                <body>
                  <p>Dear {{accountNumber}},</p>
                  <p>This is a reminder that your password is set to expire soon. To ensure uninterrupted access to your account. Please update your password before it expires.</p>
                  <p>You can change your password by visiting the company website.</p>
                  <p>If you have any questions or need assistance. Feel free to contact our support team.</p>
                  <p>Thank you for your attention to this matter.</p>
                  <p>Sincerely,</p>
                  <p>The Support Team</p>
                </body>
                </html>'
WHERE id = 5 AND notification_type = 'EMAIL';

UPDATE notification_template
SET template = '<!DOCTYPE html>
                <html>
                <body>
                  <p>Dear {{accountNumber}},</p>
                  <p>We noticed a login to your account from a new location or device.</p>
                  <p>If this was you, no further action is needed. If you do not recognize this activity. Please secure your account immediately.</p>
                  <p>Sincerely,</p>
                  <p>The Support Team</p>
                </body>
                </html>'
WHERE id = 8 AND notification_type = 'EMAIL';