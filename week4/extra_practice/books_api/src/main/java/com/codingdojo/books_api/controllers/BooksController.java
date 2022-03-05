package com.codingdojo.books_api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.books_api.models.Book;
import com.codingdojo.books_api.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/books/{book_id}/update")
    public String show_update_book(
        @PathVariable("book_id") Long book_id,
        Model model
    ) {
        model.addAttribute("page_title", "Editing");
        Book book = bookService.findBook(book_id);
        model.addAttribute("book", book);
        System.out.printf("Update get: %n%s%n", book);
        return "update_book.jsp";
    }

    @PutMapping("/books/{id}/update")
    public String update_book(
        @Valid @ModelAttribute("book") Book book,
        BindingResult result,
        @PathVariable("id") Long id
    ) {
        System.out.printf("Update put: %n%s%n", book);
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "update_book.jsp";
        }

        bookService.updateBook(book);
        return "redirect:/books/{id}";
    }

    @PostMapping("/books/{book_id}/delete")
    public String delete_book(@PathVariable("book_id") Long book_id) {
        Book book = bookService.findBook(book_id);
        bookService.deleteBook(book);
        return "redirect:/books";
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

}
