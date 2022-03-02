package com.codingdojo.books_api.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.books_api.models.Book;
import com.codingdojo.books_api.repositories.BookRepository;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }

    public void deleteBook(Book b) {
        bookRepository.delete(b);
    }

    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        return null;
    }
}
