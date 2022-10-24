package com.acme.learningcenter.learning.service;

import com.acme.learningcenter.learning.domain.model.entity.Criterion;
import com.acme.learningcenter.learning.domain.persistence.CriterionRepository;
import com.acme.learningcenter.learning.domain.service.CriterionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriterionServiceImpl implements CriterionService {

    private static final String ENTITY = "Criterion";

    private final CriterionRepository criterionRepository;

    public CriterionServiceImpl(CriterionRepository criterionRepository) {
        this.criterionRepository = criterionRepository;
    }

    @Override
    public List<Criterion> getAll() {
        return criterionRepository.findAll();
    }

    @Override
    public ResponseEntity<?> delete(Long skillId, Long criterionId) {
        return null;
    }
}
