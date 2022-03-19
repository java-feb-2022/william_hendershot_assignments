package com.codingdojo.exam_prep.mvc.services;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.models.User;
import com.codingdojo.exam_prep.mvc.repositories.ProjectRepository;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository;

    private final static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z yyyy");

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void validate(Project newProject, BindingResult result) {
        ZonedDateTime test = ZonedDateTime.parse(newProject.getDueDate().toString(), dateFormatter);
        ZonedDateTime today = ZonedDateTime.now(test.getOffset());
        
        if (test.toLocalDate().compareTo(today.toLocalDate()) < 0) {
            result.rejectValue("dueDate", "Project dueDate", "Due date must be today or in the future");
        }

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
