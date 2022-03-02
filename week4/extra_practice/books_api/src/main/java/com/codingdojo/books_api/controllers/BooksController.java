package com.codingdojo.books_api.controllers;

import java.util.List;

import com.codingdojo.books_api.models.Book;
import com.codingdojo.books_api.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/")
    public String show_index() {
        return "index.jsp";
    }

    @GetMapping("/books/{book_id}")
    public String show_book_by_id(@PathVariable(value = "book_id") Long book_id, Model model) {
        model.addAttribute("page_title", "Reading Books");
        
        Book book = bookService.findBook(book_id);

        model.addAttribute("book_title", book.getTitle());
        model.addAttribute("book_description", book.getDescription());
        model.addAttribute("book_language", book.getLanguage());
        model.addAttribute("book_num_of_pages", book.getNum_of_pages());
        return "show.jsp";
    }

    @GetMapping("/books")
    public String show_books(Model model) {
        
        model.addAttribute("page_title", "Reading Rainbow!");
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);

        return "show_all_books.jsp";
    }
}
