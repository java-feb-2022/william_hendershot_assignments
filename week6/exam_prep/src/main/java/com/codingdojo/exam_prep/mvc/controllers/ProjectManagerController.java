package com.codingdojo.exam_prep.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.models.Task;
import com.codingdojo.exam_prep.mvc.models.User;
import com.codingdojo.exam_prep.mvc.services.ProjectService;
import com.codingdojo.exam_prep.mvc.services.TaskService;
import com.codingdojo.exam_prep.mvc.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProjectManagerController {
    
    private final UserService users;
    private final ProjectService projects;
    private final TaskService tasks;

    public ProjectManagerController(UserService users, ProjectService projects, TaskService tasks) {
        this.users = users;
        this.projects = projects;
        this.tasks = tasks;
    }

    @GetMapping("/projects")
    public String showProjectsDashboard(
        Model model,
        HttpSession session
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        User user = users.getById((Long) session.getAttribute("user_id"));

        model.addAttribute("page_title", "Project Manager Dashboard");        
        model.addAttribute("joinable_projects", projects.getAllJoinableProjectsByUser(user));
        model.addAttribute("my_projects", projects.getAllByTeamMember(user));
        model.addAttribute("user", user);

        return "projects/dashboard.jsp";
    }

    @GetMapping("projects/new")
    public String showProjectsCreate(
        Model model,
        HttpSession session
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        model.addAttribute("page_title", "Create a Project");

        if (!model.containsAttribute("new_project")) {
            model.addAttribute("new_project", new Project());
        }

        return "projects/create.jsp";
    }

    @PostMapping("projects/new")
    public String createProject (
        HttpSession session,
        @Valid @ModelAttribute("new_project") Project newProject,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        projects.validate(newProject, result);

        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.new_project", result);
            redirAttr.addFlashAttribute("new_project", newProject);
            return "redirect:/projects/new";
        }

        Project project =  projects.create(newProject);
        User user = users.getById((Long) session.getAttribute("user_id"));
        projects.joinProject(project, user);

        return "redirect:/projects";
    }

    @PostMapping("/projects/{id}/join")
    public String userJoinsProject(
        HttpSession session,
        @PathVariable("id") Long id
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        User user = users.getById((Long) session.getAttribute("user_id"));
        Project project = projects.getById(id);
        projects.joinProject(project, user);

        return "redirect:/projects";
    }

    @PostMapping("/projects/{id}/leave")
    public String userLeavesProject(
        HttpSession session,
        @PathVariable("id") Long id
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        User user = users.getById((Long) session.getAttribute("user_id"));
        Project project = projects.getById(id);
        projects.leaveProject(project, user);

        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}")
    public String showProjectDetails(
        Model model,
        HttpSession session,
        @PathVariable("id") Long id
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        Project project = projects.getById(id);
        List<Task> tasks = project.getTasks();

        model.addAttribute("page_title", project.getTitle());
        model.addAttribute("project", project);
        model.addAttribute("project_tasks", tasks);

        return "projects/show_one.jsp";
    }

    @GetMapping("/projects/{id}/edit")
    public String showProjectEdit(
        Model model,
        HttpSession session,
        @PathVariable("id") Long id
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        Project project = projects.getById(id);

        model.addAttribute("page_title", project.getTitle());
        model.addAttribute("project", project);
        System.out.println(project);

        return "projects/edit.jsp";
    }

    @PutMapping("/projects/{id}")
    public String editProject (
        HttpSession session,
        @PathVariable("id") Long id,
        @Valid @ModelAttribute("project") Project project,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        if (result.hasErrors()) {
            System.out.println(result);
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.project", result);
            redirAttr.addFlashAttribute("project", project);
            return "redirect:/projects/{id}/edit";
        }

        Project _project = projects.getById(id);
        _project.setTitle(project.getTitle());
        _project.setDescription(project.getDescription());
        _project.setDueDate(project.getDueDate());

        projects.update(_project);

        return "redirect:/projects/{id}";
    }

    @DeleteMapping("projects/{id}")
    public String deleteProject(
        HttpSession session,
        @PathVariable("id") Long id
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        Project project = projects.getById(id);
        if (project.getTeamLead().getId().equals((Long) session.getAttribute("user_id"))) {
            projects.delete(project);
        }

        return "redirect:/books";
    }

    @GetMapping("projects/{id}/tasks")
    public String showProjectTasks(
        Model model,
        HttpSession session, 
        @PathVariable("id") Long id
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        Project project = projects.getById(id);
        User user = users.getById((Long) session.getAttribute("user_id"));

        model.addAttribute("page_title", project.getTitle());
        model.addAttribute("project", project);
        System.out.printf("***** Old task?: %s%n", model.getAttribute("new_task"));
        if (!model.containsAttribute("new_task")) {
            Task task = new Task();
            task.setProject(project);
            task.setUser(user);
            model.addAttribute("new_task", task);
        }

        return "projects/show_tasks.jsp";
    }

    @PostMapping("projects/{project_id}/tasks")
    public String createTask(
        HttpSession session,
        @PathVariable("project_id") Long project_id,
        @Valid @ModelAttribute("new_task") Task newTask,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        if (result.hasErrors()) {
            System.out.println(result);
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.new_task", result);
            redirAttr.addFlashAttribute("new_task", newTask);
            return "redirect:/projects/{project_id}/tasks";
        }

        tasks.create(newTask);

        return "redirect:/projects/{project_id}/tasks";
    }
}
