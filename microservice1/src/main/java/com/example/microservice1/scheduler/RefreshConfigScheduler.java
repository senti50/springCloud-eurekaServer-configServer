package com.example.microservice1.scheduler;

import com.example.microservice1.service.RefreshService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RefreshConfigScheduler {
    private static final Logger logger = LoggerFactory.getLogger(RefreshConfigScheduler.class);
    private final RefreshService refreshService;

    public RefreshConfigScheduler(RefreshService refreshService) {
        this.refreshService = refreshService;
    }

    @Scheduled(cron = "0 2/2 * * * ?")
    public void refreshConfiguration() {
        try {
            logger.info("RefreshConfigScheduler start");
            refreshService.triggerRefresh();
            logger.info("RefreshConfigScheduler end");
        } catch (Exception e) {
            logger.error("RefreshConfigScheduler error occurred: {}", e.getMessage(), e);
            // Catching exceptions to keep the scheduler running after errors
        }
    }
}
