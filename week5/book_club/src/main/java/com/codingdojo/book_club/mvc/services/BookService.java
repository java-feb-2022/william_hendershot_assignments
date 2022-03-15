package com.codingdojo.book_club.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.book_club.mvc.models.Book;
import com.codingdojo.book_club.mvc.repositories.BookRepository;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book get(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }
}
