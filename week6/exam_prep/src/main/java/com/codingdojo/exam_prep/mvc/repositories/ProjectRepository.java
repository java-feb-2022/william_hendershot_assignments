package com.codingdojo.exam_prep.mvc.repositories;

import java.util.List;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    
    public List<Project> findAll();

    public List<Project> findAllByTeamLead(User User);
}
