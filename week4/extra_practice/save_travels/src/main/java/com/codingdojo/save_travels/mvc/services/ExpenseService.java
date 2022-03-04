package com.codingdojo.save_travels.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.save_travels.mvc.models.Expense;
import com.codingdojo.save_travels.mvc.repositories.ExpenseRepository;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> all() {
        return expenseRepository.findAll();
    }

    public Expense create(Expense e) {
        return expenseRepository.save(e);
    }

    public Expense update(Expense e) {
        return expenseRepository.save(e);
    }

    public void delete(Expense e) {
        expenseRepository.delete(e);
    }

    public Expense find(Long id) {
        Optional<Expense> optional = expenseRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
