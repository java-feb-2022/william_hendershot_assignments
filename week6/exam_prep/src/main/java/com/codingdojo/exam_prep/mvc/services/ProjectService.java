package com.codingdojo.exam_prep.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.models.User;
import com.codingdojo.exam_prep.mvc.repositories.ProjectRepository;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public void delete(Project project) {
        projectRepository.delete(project);
    }

    public Project getById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            return project.get();
        }
        return null;
    }

    public List<Project> getAllByTeamMember (User user) {
        return projectRepository.findAllByTeamMemberUserId(user.getId());
    }

    public List<Project> getAllJoinableProjectsByUser (User user) {
        return projectRepository.findAllJoinableProjectsByUserId(user.getId());
    }

    public void joinProject(Project project, User user) {
        List<User> projectMembers = project.getProjectMembers();
        projectMembers.add(user);
        projectRepository.save(project);
    }

    public void leaveProject(Project project, User user) {
        List<User> projectMembers = project.getProjectMembers();
        projectMembers.remove(user);
        projectRepository.save(project);
    }
}
