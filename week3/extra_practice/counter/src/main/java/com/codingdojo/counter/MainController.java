package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    
    @RequestMapping("/")
    public String display_index(HttpSession session) {
        
        if (checkSessionCounter(session)) {
            session.setAttribute("counter",(Integer) session.getAttribute("counter") + 1);
        } else {
            resetSessionCounter(session);
        }

        return "index.jsp";
    }

    @RequestMapping("/plus2") 
    public String display_plus2(HttpSession session) {
        
        if (checkSessionCounter(session)) {
            session.setAttribute("counter",(Integer) session.getAttribute("counter") + 2);
        } else {
            resetSessionCounter(session);
        }

        return "index.jsp";
    }

    @RequestMapping("/resetCounter") 
    public String resetCounter(HttpSession session) {

        resetSessionCounter(session);
        return "redirect:/counter";
    }

    @RequestMapping("/counter")
    public String display_counter(HttpSession session, Model model) {

        if (!checkSessionCounter(session)) {
            resetSessionCounter(session);
        }

        model.addAttribute("counter",(Integer) session.getAttribute("counter"));

        return "counter.jsp";
    }

    private boolean checkSessionCounter(HttpSession session) {
        return session.getAttribute("counter") != null;
    }

    private void resetSessionCounter(HttpSession session) {
        session.setAttribute("counter", 0);
    }
}
