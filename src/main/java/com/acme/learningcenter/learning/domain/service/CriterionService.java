package com.acme.learningcenter.learning.domain.service;

import com.acme.learningcenter.learning.domain.model.entity.Criterion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CriterionService {
    List<Criterion> getAll();

    Criterion getByNameAndSkillId(String name, Long skillId);

    ResponseEntity<?> delete(Long skillId, Long criterionId);
}
