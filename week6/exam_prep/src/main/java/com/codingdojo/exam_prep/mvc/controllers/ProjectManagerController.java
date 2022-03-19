package com.codingdojo.exam_prep.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.exam_prep.mvc.models.Project;
import com.codingdojo.exam_prep.mvc.services.ProjectService;
import com.codingdojo.exam_prep.mvc.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProjectManagerController {
    
    private final UserService users;
    private final ProjectService projects;

    public ProjectManagerController(UserService users, ProjectService projects) {
        this.users = users;
        this.projects = projects;
    }

    @GetMapping("/projects")
    public String showProjectsDashboard(
        Model model,
        HttpSession session
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        model.addAttribute("page_title", "Project Manager Dashboard");
        model.addAttribute("projects", projects.getAll());
        model.addAttribute("user", users.getById((Long) session.getAttribute("user_id")));

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

        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.new_project", result);
            redirAttr.addFlashAttribute("new_project", newProject);
            return "redirect:/projects/new";
        }

        projects.create(newProject);

        return "redirect:/projects";
    }
}
