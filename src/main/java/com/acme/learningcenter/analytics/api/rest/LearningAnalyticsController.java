package com.acme.learningcenter.analytics.api.rest;

import com.acme.learningcenter.analytics.domain.service.LearningAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/analytics/learning")
public class LearningAnalyticsController {

    private final LearningAnalyticsService learningAnalyticsService;

    public LearningAnalyticsController(LearningAnalyticsService learningAnalyticsService) {
        this.learningAnalyticsService = learningAnalyticsService;
    }

    @GetMapping("/students/total")
    public int getTotalStudents() {
        return learningAnalyticsService.getTotalStudents();
    }
}
