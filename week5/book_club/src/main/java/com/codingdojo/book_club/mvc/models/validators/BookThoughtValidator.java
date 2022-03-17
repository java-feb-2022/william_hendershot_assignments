package com.codingdojo.book_club.mvc.models.validators;

import com.codingdojo.book_club.mvc.models.BookThought;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookThoughtValidator implements Validator {
    
    @Override
    public boolean supports (Class clazz) {
        return BookThought.class.equals (clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
    }
}
