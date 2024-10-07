package com.example.NotificationService.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfig {
    @Value("${twilio.account_sid}")
    private String accountSid;
    @Value("${twilio.auth_token}")
    private String authToken;
    @Value("${twilio.phone_number}")
    private String trialNumber;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public String getTwilioPhoneNumber() {
        return trialNumber;
    }
}
