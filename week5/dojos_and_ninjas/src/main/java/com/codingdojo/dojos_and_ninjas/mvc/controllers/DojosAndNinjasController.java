package com.codingdojo.dojos_and_ninjas.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.dojos_and_ninjas.mvc.models.Dojo;
import com.codingdojo.dojos_and_ninjas.mvc.models.Ninja;
import com.codingdojo.dojos_and_ninjas.mvc.services.DojoService;
import com.codingdojo.dojos_and_ninjas.mvc.services.NinjaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DojosAndNinjasController {
    
    @Autowired
    private final DojoService dojoService;
    @Autowired
    private final NinjaService ninjaService;

    public DojosAndNinjasController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/")
    public String show_index(
        Model model
    ) {
        model.addAttribute("page_title", "Index");

        return "index.jsp";
    }

    @GetMapping("/dojos")
    public String show_dojos (
        Model model
    ) {
        List<Dojo> dojos = dojoService.getAll();
        
        model.addAttribute("page_title", "Dojos");
        model.addAttribute("dojos", dojos);
        
        return "dojos/list.jsp";
    }

    @GetMapping("/dojos/new")
    public String show_new_dojo (
        Model model
    ) {

        model.addAttribute("page_title", "New Dojo");
        if (!model.containsAttribute("dojo")) {
            model.addAttribute("dojo", new Dojo());
        }

        return "dojos/create.jsp";
    }

    @PostMapping("/dojos")
    public String create_dojo (
        Model model,
        @Valid @ModelAttribute Dojo dojo,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {

        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.dojo", result);
            redirAttr.addFlashAttribute("dojo", dojo);
            return "redirect:/dojos/new";
        }

        dojoService.create(dojo);

        return "redirect:/dojos/";
    }

    @GetMapping("/dojos/{id}")
    public String show_dojo_details(
        Model model,
        @PathVariable("id") Long id
    ) {
        
        Dojo dojo = dojoService.get(id);
        List<Ninja> ninjas = ninjaService.getAllByDojo(dojo);

        model.addAttribute("page_title", dojo.getName());
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", ninjas);
        

        return "dojos/details.jsp";
    }

    @GetMapping("/dojos/{id}/edit")
    public String show_dojo_edit (
        Model model,
        @PathVariable("id") Long id
    ) {
        Dojo dojo = dojoService.get(id);

        model.addAttribute("page_title", dojo.getName());
        model.addAttribute("dojo", dojo);

        return "dojos/edit.jsp";
    }
}
