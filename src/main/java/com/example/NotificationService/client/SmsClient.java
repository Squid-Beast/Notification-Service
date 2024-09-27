package com.example.NotificationService.client;

import com.example.NotificationService.config.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsClient {

    @Autowired
    private TwilioConfig twilioConfig;

    public void sendSms(String toPhoneNumber, String messageContent) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(toPhoneNumber),
                    new PhoneNumber(twilioConfig.getTwilioPhoneNumber()),
                    messageContent
            ).create();
            log.info("SMS sent successfully: {}", message.getSid());
        } catch (Exception e) {
            log.info("Failed to send SMS to: {}",toPhoneNumber,e);
        }
    }
}
