package com.codingdojo.exam_prep.mvc.repositories;

import java.util.List;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.models.Task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    
    public List<Task> findAllByProject(Project project);

    public List<Task> findAll();

}
