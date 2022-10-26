package com.acme.learningcenter.learning.service;

import com.acme.learningcenter.learning.api.internal.LearningContextFacade;
import com.acme.learningcenter.learning.domain.model.entity.Skill;
import com.acme.learningcenter.learning.domain.model.entity.Student;
import com.acme.learningcenter.learning.domain.service.SkillService;
import com.acme.learningcenter.learning.domain.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningContextFacadeImpl implements LearningContextFacade {

    private final SkillService skillService;
    private final StudentService studentService;

    public LearningContextFacadeImpl(SkillService skillService, StudentService studentService) {
        this.skillService = skillService;
        this.studentService = studentService;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillService.getAll();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }
}
