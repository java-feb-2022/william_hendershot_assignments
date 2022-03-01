package com.codingdojo.ninja_gold_game.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.codingdojo.ninja_gold_game.game.VisitFactory;
import com.codingdojo.ninja_gold_game.game.commands.Visit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainSiteController {
    
    VisitFactory sites = new VisitFactory();
    HashMap<String, ArrayList<Visit>> sessions = new HashMap<String, ArrayList<Visit>>();

    @GetMapping("/")
    public String game_loop(HttpSession session, Model model){
        
        
        // if (!(boolean)session.getAttribute("is_playing")) {
        //     startup(session);
        // }
        sites.getCommandNames();
            

        return "index.jsp";
    }

    private void startup(HttpSession session) {
        if (!session.isNew()){
            session.invalidate();
        }
        session.setAttribute("is_playing", true);
        session.setAttribute("gold_held", 0);
        session.setAttribute("transaction_history", new ArrayList<String>());
        // session.setAttribute("commands", sites.getCommandNames());
    }
}
