package com.codingdojo.exam_prep.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.models.Task;
import com.codingdojo.exam_prep.mvc.repositories.TaskRepository;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getById(Long id) {
        Optional<Task> project = taskRepository.findById(id);
        if (project.isPresent()) {
            return project.get();
        }
        return null;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public List<Task> getAllByProject(Project project) {
        return taskRepository.findAllByProject(project);
    }
}
