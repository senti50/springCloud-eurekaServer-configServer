package com.example.microservice1.service;

import com.example.microservice1.utils.ApiEndpoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RefreshService {
    private static final Logger logger = LoggerFactory.getLogger(RefreshService.class);
    private final RestTemplate restTemplate;

    public RefreshService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void triggerRefresh() {
        ResponseEntity<String> response = restTemplate.postForEntity(ApiEndpoints.ACTUATOR_REFRESH_URL, null, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            logger.info("Configuration refreshed successfully!");
        } else {
            logger.error("Failed to refresh configuration: {}", response.getStatusCode());
        }
    }
}
