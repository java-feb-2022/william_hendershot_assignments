package com.codingdojo.omikuji_form;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String display_index () {
        return "redirect:/omikuji";
    }

    @GetMapping("/omikuji")
    public String display_omikuji() {
        return "omikuji.jsp";
    }

    @PostMapping("/omikuji/send")
    public String process_omikuji(HttpSession session,
        @RequestParam(value="pick_number", required=false) Integer pick_number,
        @RequestParam(value="city", required=false) String city,
        @RequestParam(value="person", required=false) String person,
        @RequestParam(value="hobby", required=false) String hobby,
        @RequestParam(value="animal", required=false) String animal,
        @RequestParam(value="say_something_nice", required=false) String say_something_nice) {

        session.setAttribute("pick_number", pick_number);
        session.setAttribute("city", city);
        session.setAttribute("person", person);
        session.setAttribute("hobby", hobby);
        session.setAttribute("animal", animal);
        session.setAttribute("say_something_nice", say_something_nice);
        
        return "redirect:/omikuji/show";
    }

    @GetMapping("/omikuji/show")
    public String show_omikuji(HttpSession session, Model model) {

        model.addAttribute("pick_number", session.getAttribute("pick_number"));
        model.addAttribute("city", session.getAttribute("city"));
        model.addAttribute("person", session.getAttribute("person"));
        model.addAttribute("hobby", session.getAttribute("hobby"));
        model.addAttribute("animal", session.getAttribute("animal"));
        model.addAttribute("say_something_nice", session.getAttribute("say_something_nice"));

        return "show_omikuji.jsp";
    }
}
