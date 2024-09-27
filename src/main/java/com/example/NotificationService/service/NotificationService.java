package com.example.NotificationService.service;

import com.example.NotificationService.client.EmailClient;
import com.example.NotificationService.client.SmsClient;
import com.example.NotificationService.client.UserClient;
import com.example.NotificationService.entity.Category;
import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.pojo.CategoryDetails;
import com.example.NotificationService.pojo.NotificationPreferences;
import com.example.NotificationService.pojo.NotificationRequest;
import com.example.NotificationService.pojo.UserDetails;
import com.example.NotificationService.repository.CategoryRepository;
import com.example.NotificationService.repository.NotificationTemplateRepository;
import com.example.NotificationService.validation.NotificationRequestValidator;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRequestValidator validator;

    @Autowired
    private UserClient client;

    @Autowired
    private SmsClient smsClient;

    @Autowired
    private EmailClient emailClient;

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NotificationTemplateRepository notificationTemplateRepository;

    public NotificationRequest sendNotification(NotificationRequest notificationRequest) {

        validator.validateNotificationRequest(notificationRequest);

        UserDetails userDetails = client.getUserDetailsById(notificationRequest.getUserId());

        Optional<Category> categoryOptional = categoryRepository.findByName(notificationRequest.getNotificationCategory());

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();

        if (userDetails.getUserPreferences().isDisableAllNotifications()) {
            log.info("User enabled disable all notifications.");
        }

        if (userDetails.getUserPreferences().isCriticalNotificationOnly() && !category.isCritical()) {
            log.info("User didn't enabled this category as critical.");
        }

        List<NotificationPreferences> notificationPreferencesList = userDetails.getUserPreferences().getNotificationPreferences();

        Optional<NotificationPreferences> notificationPreferences = notificationPreferencesList.stream()
                .filter(notificationPreference -> notificationPreference.getCategory().equals(notificationRequest.getNotificationCategory()))
                .findFirst();

        List<Notification> notificationTemplateList = category.getNotificationTemplateList();
        Map<String, Object> data = new HashMap<>();
        data.put("accountNumber", notificationRequest.getData().get("accountNumber"));

        for (Notification template : notificationTemplateList) {
            String message = getMessageTemplate(template.getNotificationTemplate(), data);
            log.info(message);
            if (notificationRequest.getNotificationType().contains("SMS")){
                smsClient.sendSms(userDetails.getMobile(), message);
            }
            if (notificationRequest.getNotificationType().contains("EMAIL")){
                emailClient.sendEmail(userDetails.getEmail(), template.getSubject(),message);
                log.info("Email sent Successfully");
            }
        }

        return notificationRequest;
    }

    private String getMessageTemplate(String templateContent, Map<String, Object> data) {
        MustacheFactory mustacheFactory = new DefaultMustacheFactory();
        StringWriter writer = new StringWriter();
        try {
            Mustache mustache = mustacheFactory.compile(new StringReader(templateContent), "template");
            mustache.execute(writer, data);
        } catch (Exception e) {
            log.error("Error compiling or executing template", e);
            return "Error generating message";
        }

        return writer.toString();
    }

    public UserDetails getNotificationPreferences(Long userId) {
        return client.getUserDetailsById(userId);
    }

}
