package com.codingdojo.full_crud_save_travels.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.full_crud_save_travels.mvc.models.Expense;
import com.codingdojo.full_crud_save_travels.mvc.services.ExpenseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping("/expenses/edit/{id}")
    public String show_edit(
        @PathVariable("id") Long id,
        Model model
    ) {
        
        Expense expense = expenseService.get(id);

        model.addAttribute("page_title", "Edit my Task");
        model.addAttribute("expense", expense);

        return "expenses/edit.jsp";
    }

    @PutMapping("/expenses/edit/{id}")
    public String edit(
        @Valid @ModelAttribute("expense") Expense e,
        BindingResult result,
        @PathVariable("id") Long id
    ) {
        if (result.hasErrors()) {
            return "expenses/edit.jsp";
        }

        Expense _expense = expenseService.get(id);
        _expense.setName(e.getName());
        _expense.setVendor(e.getVendor());
        _expense.setAmount(e.getAmount());
        _expense.setDescription(e.getDescription());

        expenseService.update(e);
        
        return "redirect:/expenses";
    }
}
