package com.codingdojo.books_api.controllers;

import java.util.List;

import com.codingdojo.books_api.models.Book;
import com.codingdojo.books_api.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/books/create")
    public String show_create_book(Model model) {
        model.addAttribute("page_title", "Add a Book");

        return "create_book.jsp";
    }

    @PostMapping("/books")
    public String create_new_book(
        @RequestParam("book_title") String title,
        @RequestParam("book_description") String description,
        @RequestParam("book_language") String language,
        @RequestParam("book_num_of_pages") Integer pages
    ) {

        Book book = new Book(title, description, language, pages);
        bookService.createBook(book);
        return "redirect:/books";
    }


    @PostMapping("/books/{book_id}")
    public String update_book(
        @PathVariable("book_id") Long book_id,
        @RequestParam("book_title") String title,
        @RequestParam("book_description") String description,
        @RequestParam("book_language") String language,
        @RequestParam("book_num_of_pages") Integer pages
    ) {

        Book book = bookService.findBook(book_id);
        book.setTitle(title);
        book.setDescription(description);
        book.setLanguage(language);
        book.setNum_of_pages(pages);
        bookService.updateBook(book);

        return String.format("redirect:/books/%s", book_id);
    }

    @GetMapping("/books/{book_id}/update")
    public String show_update_book(
        @PathVariable("book_id") Long book_id,
        Model model
    ) {
        model.addAttribute("page_title", "Editing");
        Book book = bookService.findBook(book_id);
        model.addAttribute("book_id", book.getId());
        model.addAttribute("book_title", book.getTitle());
        model.addAttribute("book_language", book.getLanguage());
        model.addAttribute("book_description", book.getDescription());
        model.addAttribute("book_num_of_pages", book.getNum_of_pages());

        return "update_book.jsp";
    }

}
