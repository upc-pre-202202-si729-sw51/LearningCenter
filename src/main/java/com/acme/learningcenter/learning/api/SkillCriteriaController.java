package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.service.CriterionService;
import com.acme.learningcenter.learning.domain.service.SkillService;
import com.acme.learningcenter.learning.mapping.CriterionMapper;
import com.acme.learningcenter.learning.resource.CreateCriterionResource;
import com.acme.learningcenter.learning.resource.CriterionResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skills/{skillId}/criteria")
public class SkillCriteriaController {

    private final SkillService skillService;

    private final CriterionService criterionService;

    private final CriterionMapper mapper;

    public SkillCriteriaController(SkillService skillService, CriterionService criterionService, CriterionMapper mapper) {
        this.skillService = skillService;
        this.criterionService = criterionService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CriterionResource> getAllCriteriaBySkillId(@PathVariable Long skillId,
                                                           Pageable pageable) {
        return mapper.modelListPage(skillService.getById(skillId)
                        .getCriteria().stream().toList(), pageable);
    }

    @PostMapping
    public CriterionResource createCriterion(@PathVariable Long skillId,
                                             @RequestBody CreateCriterionResource resource) {

        skillService.addCriterionToSkill(skillId, resource.getName());
        return mapper.toResource(criterionService
                .getByNameAndSkillId(resource.getName(), skillId));
    }
}
