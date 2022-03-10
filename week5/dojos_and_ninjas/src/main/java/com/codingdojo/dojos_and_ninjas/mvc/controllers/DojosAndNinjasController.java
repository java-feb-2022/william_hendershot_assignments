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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/ninjas")
    public String show_ninjas (
        Model model
    ) {

        List<Ninja> ninjas = ninjaService.getAll();

        model.addAttribute("page_title", "Ninjas");
        model.addAttribute("ninjas", ninjas);

        return "ninjas/list.jsp";
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

    @GetMapping("/ninjas/new")
    public String show_new_ninja (
        Model model
    ) {

        model.addAttribute("page_title", "New Ninja");
        model.addAttribute("dojos", dojoService.getAll());
        if (!model.containsAttribute("ninja")) {
            model.addAttribute("ninja", new Ninja());
        }

        return "ninjas/create.jsp";
    }

    @PostMapping("/dojos")
    public String create_dojo (
        Model model,
        @Valid @ModelAttribute("dojo") Dojo dojo,
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

    @PostMapping("/ninjas")
    public String create_ninja (
        Model model,
        @Valid @ModelAttribute("ninja") Ninja ninja,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {
        
        System.out.println(model.getAttribute("dojos"));
        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.ninja", result);
            redirAttr.addFlashAttribute("ninja", ninja);
            return "redirect:/ninjas/new";
        }
        
        ninjaService.create(ninja);
        return "redirect:/ninjas";
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

    @GetMapping("/ninjas/{id}")
    public String show_ninja_details (
        Model model,
        @PathVariable("id") Long id
    ) {

        Ninja ninja = ninjaService.get(id);
        Dojo dojo = ninja.getDojo();

        model.addAttribute("page_title", ninja.getFirst_name());
        model.addAttribute("ninja", ninja);
        model.addAttribute("dojo", dojo);

        return "ninjas/details.jsp";
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

    @GetMapping("/ninjas/{id}/edit")
    public String show_ninja_edit (
        Model model,
        @PathVariable("id") Long id
    ) {

        Ninja ninja = ninjaService.get(id);
        List<Dojo> dojos = dojoService.getAll();

        model.addAttribute("page_title", ninja.getFirst_name());
        model.addAttribute("ninja", ninja);
        model.addAttribute("dojos", dojos);

        return "ninjas/edit.jsp";
    }
    
    @PutMapping("/dojos/{id}")
    public String edit_dojo (
        @PathVariable("id") Long id,
        @Valid @ModelAttribute("dojo") Dojo dojo,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {
        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.dojo", result);
            redirAttr.addFlashAttribute("dojo", dojo);
            return "redirect:/dojos/{id}/edit";
        }

        Dojo _dojo = dojoService.get(id);
        _dojo.setName(dojo.getName());

        dojoService.update(_dojo);

        return "redirect:/dojos/{id}";
    }

    @PutMapping("ninjas/{id}")
    public String edit_ninja (
        @PathVariable("id") Long id,
        @Valid @ModelAttribute("ninja") Ninja ninja,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {
        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.ninja", result);
            redirAttr.addFlashAttribute("ninja", ninja);
            return "redirect:/ninjas{id}/edit";
        }

        Ninja _ninja = ninjaService.get(id);
        _ninja.setFirst_name(ninja.getFirst_name());
        _ninja.setLast_name(ninja.getLast_name());
        _ninja.setAge(ninja.getAge());
        _ninja.setDojo(ninja.getDojo());

        ninjaService.update(_ninja);

        return "redirect:/ninjas/{id}";
    }

    @DeleteMapping("/dojos/{id}")
    public String delete_dojo (
        @PathVariable("id") Long id
    ) {
        dojoService.delete(id);
        return "redirect:/dojos";
    }

    @DeleteMapping("/ninjas/{id}")
    public String delete_ninja (
        @PathVariable("id") Long id
    ) {
        ninjaService.delete(id);
        return "redirect:/ninjas";
    }
}
