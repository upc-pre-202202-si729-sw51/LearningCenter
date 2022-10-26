package com.acme.learningcenter.analytics.service;

import com.acme.learningcenter.analytics.domain.service.LearningAnalyticsService;
import com.acme.learningcenter.learning.api.internal.LearningContextFacade;
import org.springframework.stereotype.Service;

@Service
public class LearningAnalyticsServiceImpl implements LearningAnalyticsService {
    private final LearningContextFacade learningContextFacade;

    public LearningAnalyticsServiceImpl(LearningContextFacade learningContextFacade) {
        this.learningContextFacade = learningContextFacade;
    }

    @Override
    public int getTotalStudents() {
        return learningContextFacade.getAllStudents().size();
    }
}
