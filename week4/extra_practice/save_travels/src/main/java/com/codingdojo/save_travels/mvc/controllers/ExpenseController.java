package com.codingdojo.save_travels.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.save_travels.mvc.models.Expense;
import com.codingdojo.save_travels.mvc.services.ExpenseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public String show_index(Model model) {
        model.addAttribute("page_title", "Index");
        return "index.jsp";
    }

    @GetMapping("/expenses")
    public String show_expenses(
        Model model,
        @ModelAttribute Expense expense
    ) {
        
        List<Expense> expenses = expenseService.all();
        
        model.addAttribute("page_title", "Read Share");
        model.addAttribute("expenses", expenses);
        
        return "expenses/show.jsp";
    }

    @PostMapping("/expenses")
    public String add_expense(
        @Valid @ModelAttribute Expense expense,
        BindingResult result
    ) {

        if (result.hasErrors()) {
            return "expenses/show.jsp";
        }
        expenseService.create(expense);
        return "redirect:/expenses";
    }
}
