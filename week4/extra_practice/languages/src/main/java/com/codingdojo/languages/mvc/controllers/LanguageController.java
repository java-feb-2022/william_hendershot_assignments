package com.codingdojo.languages.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.languages.mvc.models.Language;
import com.codingdojo.languages.mvc.services.LanguageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class LanguageController {
    
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/")
    public String show_index(Model model) {

        model.addAttribute("page_title", "Index");

        return "index.jsp";

    }

    @GetMapping("/languages")
    public String show_languages(Model model) {

        List<Language> languages = languageService.getAll();

        model.addAttribute("page_title", "Languages");
        model.addAttribute("languages", languages);

        return "languages/index.jsp";
    }

    @PostMapping("/languages")
    public String create_language (
        @Valid @ModelAttribute Language language,
        BindingResult result
    ) {
        
        if (result.hasErrors()) {
            return "languages/index.jsp";
        }

        languageService.create(language);

        return "redirect:/languages";
    }

    @GetMapping("/languages/{id}")
    public String show_one (
        Model model,
        @PathVariable("id") Long id
    ) {
        Language l = languageService.get(id);
        
        model.addAttribute("page_title", l.getName());
        model.addAttribute("language", l);

        return "languages/details.jsp";
    }

    @GetMapping("/languages/{id}/edit")
    public String show_edit (
        @PathVariable("id") Long id,
        Model model
    ) {
        Language l = languageService.get(id);

        model.addAttribute("page_title", l.getName());
        model.addAttribute("language", l);

        return "languages/edit.jsp";
    }

    @PutMapping("/languages/{id}/edit")
    public String edit (
        @Valid @ModelAttribute("language") Language language,
        BindingResult result,
        @PathVariable("id") Long id
    ) {
        if (result.hasErrors()) {
            return "langauges/edit.jsp";
        }

        Language _l = languageService.get(id);
        _l.setName(language.getName());
        _l.setCreator(language.getCreator());
        _l.setVersion(language.getVersion());

        languageService.update(_l);

        return "redirect:/languages";
    }

    @DeleteMapping("/languages/{id}")
    public String delete(
        @PathVariable("id") Long id
    ) {
        languageService.delete(id);
        return "redirect:/languages";
    }
}
