package com.example.NotificationService.client;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class EmailClient {
    @Autowired
    private SendGrid sendGridClient;
    public void sendEmail(String toEmail, String subject, String content) {
        Email from = new Email("nlohithkumar.18.it@anits.edu.in");
        Email to = new Email(toEmail);
        Content emailContent = new Content("text/html", content);
        Mail mail = new Mail(from, subject, to, emailContent);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGridClient.api(request);
            log.info("Email sent successfully to {}", toEmail);
        } catch (IOException ex) {
            log.error("Error sending email: {}", ex.getMessage());
        }
    }
}
