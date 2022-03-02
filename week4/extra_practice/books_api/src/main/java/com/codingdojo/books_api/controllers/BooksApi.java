package com.codingdojo.books_api.controllers;

import java.util.List;

import com.codingdojo.books_api.models.Book;
import com.codingdojo.books_api.services.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksApi {
    
    private final BookService bookService;
    
    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> api_books() {
        return bookService.allBooks();
    }

    @PostMapping("api/books")
    public Book api_create_book(
        @RequestParam(value="title") String title,
        @RequestParam(value="description") String description,
        @RequestParam(value="language") String language,
        @RequestParam(value="num_of_pages") Integer num_of_pages
    ) {
        Book book = new Book(title, description, language, num_of_pages);
        return bookService.createBook(book);
    }


    @PutMapping("/api/books/{book_id}")
    public Book api_update_book(
        @PathVariable("book_id") Long book_id,
        @RequestParam(value="title") String title,
        @RequestParam(value="description") String description,
        @RequestParam(value="language") String language,
        @RequestParam(value="num_of_pages") Integer num_of_pages
    ) {
        Book book = bookService.findBook(book_id);
        book.setTitle(title);
        book.setDescription(description);
        book.setLanguage(language);
        book.setNum_of_pages(num_of_pages);
        return bookService.updateBook(book);
    }
}
