package com.example.NotificationService.client;

import com.example.NotificationService.exception.UserDetailsNotFoundException;
import com.example.NotificationService.pojo.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class UserClient {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.service.endpoint}")
    private String userEndpoint;

    public UserDetails getUserDetailsById(Long userId) {
        try {
            ResponseEntity<UserDetails> responseEntity = restTemplate.exchange(
                    userEndpoint + "/" + userId,
                    HttpMethod.GET,
                    buildHttpEntity(),
                    UserDetails.class
            );
            return responseEntity.getBody();
        } catch (UserDetailsNotFoundException e) {
            throw e;
        }
    }

    private HttpEntity buildHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        return new HttpEntity<>(headers);
    }
}
