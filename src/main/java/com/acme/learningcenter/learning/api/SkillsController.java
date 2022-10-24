package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.service.SkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillsController {

    private final SkillService skillService;


    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }
}
