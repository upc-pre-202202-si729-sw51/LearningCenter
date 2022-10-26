package com.acme.learningcenter.learning.api.internal;

import com.acme.learningcenter.learning.domain.model.entity.Skill;
import com.acme.learningcenter.learning.domain.model.entity.Student;

import java.util.List;

public interface LearningContextFacade {
    List<Skill> getAllSkills();
    List<Student> getAllStudents();
}
