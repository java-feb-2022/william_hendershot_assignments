package com.codingdojo.book_club.mvc.services;

import java.util.List;

import com.codingdojo.book_club.mvc.models.Book;
import com.codingdojo.book_club.mvc.models.BookThought;
import com.codingdojo.book_club.mvc.models.User;
import com.codingdojo.book_club.mvc.repositories.BookThoughtRepository;

import org.springframework.stereotype.Service;

@Service
public class BookThoughtService {
    
    private final BookThoughtRepository bookThoughtRepository;

    public BookThoughtService(BookThoughtRepository bookThoughtRepository) {
        this.bookThoughtRepository = bookThoughtRepository;
    }

    public BookThought create (BookThought bookThought) {
        return bookThoughtRepository.save(bookThought);
    }
    
    public BookThought update (BookThought bookThought) {
        return bookThoughtRepository.save(bookThought);
    }

    public void delete (BookThought bookThought) {
        bookThoughtRepository.delete(bookThought);
    }

    public List<BookThought> getAllByUser(User user) {
        return bookThoughtRepository.findAllByUser(user);
    }

    public List<BookThought> getAllByBook(Book book) {
        return bookThoughtRepository.findAllByBook(book);
    }
}
