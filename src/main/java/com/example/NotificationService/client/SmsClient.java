package com.example.NotificationService.client;

import com.example.NotificationService.config.TwilioConfig;
import com.example.NotificationService.entity.MessageLog;
import com.example.NotificationService.repository.MessageLogRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsClient {

    private static final int MAX_RETRY_COUNT = 3;
    boolean success = false;
    @Autowired
    private TwilioConfig twilioConfig;
    @Autowired
    private MessageLogRepository messageLogRepository;

    public void sendSms(String toPhoneNumber, String messageContent) {
        for (int retryCount = 1; retryCount <= MAX_RETRY_COUNT; retryCount++) {
            try {
                Message message = Message.creator(
                        new PhoneNumber(toPhoneNumber),
                        new PhoneNumber(twilioConfig.getTwilioPhoneNumber()),
                        messageContent
                ).create();
                log.info("SMS sent successfully: {}", message.getSid());
                saveSmsLog(message.getSid(), toPhoneNumber, messageContent, message.getStatus().toString(), retryCount);
                log.info("SMS data saved successfully into database.");
                success = true;
                break;
            } catch (Exception e) {
                log.info("Failed to send SMS to: {}", toPhoneNumber, e);
            }
            if (retryCount == MAX_RETRY_COUNT && !success) {
                log.info("Failed to send SMS to: {} after {} attempts.", toPhoneNumber, MAX_RETRY_COUNT);
            }
        }
    }

    private void saveSmsLog(String messageId, String recipient, String content, String status, int retryCount) {
        MessageLog smsMessageLog = new MessageLog("Twilio", messageId, recipient, content, status, retryCount);
        messageLogRepository.save(smsMessageLog);
    }
}
