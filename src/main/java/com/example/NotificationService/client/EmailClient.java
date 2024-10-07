package com.example.NotificationService.client;

import com.example.NotificationService.entity.MessageLog;
import com.example.NotificationService.repository.MessageLogRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class EmailClient {
    private static final int MAX_RETRY_COUNT = 3;
    boolean success = false;
    @Autowired
    private SendGrid sendGridClient;
    @Value("${spring.mail.username}")
    private String fromEmail;
    @Autowired
    private MessageLogRepository messageLogRepository;

    public void sendEmail(String toEmail, String subject, String content) {
        Email from = new Email(fromEmail);
        Email to = new Email(toEmail);
        Content emailContent = new Content("text/html", content);
        Mail mail = new Mail(from, subject, to, emailContent);

        Request request = new Request();
        for (int retryCount = 1; retryCount <= MAX_RETRY_COUNT; retryCount++) {
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sendGridClient.api(request);
                if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                    log.info("Email sent successfully to: {}", toEmail);
                    saveEmailLog(String.valueOf(response.getHeaders()), toEmail, String.valueOf(emailContent), String.valueOf(response.getStatusCode()), retryCount);
                    log.info("EMAIL data saved successfully into database.");
                    success = true;
                    break;
                } else {
                    log.info("Error sending email on attempt {}", retryCount);
                }
            } catch (IOException ex) {
                log.error("Error sending email: {}", ex.getMessage());
            }
            if (retryCount == MAX_RETRY_COUNT && !success) {
                log.info("Failed to send email to: {} after {} attempts.", toEmail, MAX_RETRY_COUNT);
            }
        }
    }

    private void saveEmailLog(String messageId, String recipient, String content, String status, int retryCount) {
        MessageLog emailMessageLog = new MessageLog("SendGrid", messageId, recipient, content, status, retryCount);
        messageLogRepository.save(emailMessageLog);
    }
}
