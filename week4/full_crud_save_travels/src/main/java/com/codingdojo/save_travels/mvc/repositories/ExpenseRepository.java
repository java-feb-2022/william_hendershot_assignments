package com.codingdojo.save_travels.mvc.repositories;

import java.util.List;

import com.codingdojo.save_travels.mvc.models.Expense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
    
    List<Expense> findAll();

}
