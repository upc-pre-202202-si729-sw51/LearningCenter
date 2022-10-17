package com.acme.learningcenter.learning.domain.persistence;

import com.acme.learningcenter.learning.domain.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
