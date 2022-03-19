package com.codingdojo.exam_prep.mvc.repositories;

import java.util.List;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    
    public List<Project> findAll();

    public List<Project> findAllByTeamLead(User User);

    @Query(
        value = "SELECT * FROM projects WHERE id IN (SELECT project_id FROM team_members WHERE user_id = ?1)",
        nativeQuery = true
    )
    public List<Project> findAllByTeamMemberUserId (Long user_id);

    @Query(
        value = "SELECT * FROM projects WHERE id NOT IN (SELECT project_id FROM team_members WHERE user_id = ?1)",
        nativeQuery = true
    )
    public List<Project> findAllJoinableProjectsByUserId (Long user_id);
}
