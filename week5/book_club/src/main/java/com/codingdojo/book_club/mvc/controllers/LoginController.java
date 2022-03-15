package com.codingdojo.book_club.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.book_club.mvc.models.LoginUser;
import com.codingdojo.book_club.mvc.models.User;
import com.codingdojo.book_club.mvc.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showIndex(
        Model model,
        HttpSession session
    ) {

        if (session.getAttribute("user_id") != null) {
            return "redirect:/books";
        }
        model.addAttribute("page_title", "Read Share");
        if (!model.containsAttribute("new_user")) {
            model.addAttribute("new_user", new User());
        }
        if (!model.containsAttribute("potential_user")) {
            model.addAttribute("potential_user", new LoginUser());
        }

        return "login/login_register.jsp";
    }

    @PostMapping("/register")
    public String registerNewUser(
        @Valid @ModelAttribute("new_user") User newUser,
        BindingResult result,
        RedirectAttributes redirAttr,
        HttpSession session
    ) {

        //Validate user
        userService.validate(newUser, result);
        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.new_user", result);
            redirAttr.addFlashAttribute("new_user", newUser);
            return "redirect:/";
        }

        //Register user
        User user = userService.register(newUser);
        System.out.println(user);
        
        //Put user into session
        session.setAttribute("user_id", user.getId());

        return "redirect:/books";
    }

    @PostMapping("/logout")
    public String logout (
        HttpSession session
    ) {
        
        session.removeAttribute("user_id");
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login (
        @Valid @ModelAttribute("potential_user") LoginUser loginUser,
        BindingResult result,
        RedirectAttributes redirAttr,
        HttpSession session
    ) {

        //Authenticate user
        User user = userService.authenticate(loginUser, result);
        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.potential_user", result);
            redirAttr.addFlashAttribute("potential_user", loginUser);
            return "redirect:/";
        }

        //Put user into session
        if (user != null) {
            session.setAttribute("user_id", user.getId());
            return "redirect:/books";
        }
        
        return "redirect:/";
    }
}
