package com.codingdojo.book_club.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.book_club.mvc.models.Book;
import com.codingdojo.book_club.mvc.services.BookService;
import com.codingdojo.book_club.mvc.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BooksController {
    
    private final BookService bookService;
    private final UserService userService;

    public BooksController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/books")
    public String showBooks(
        Model model,
        HttpSession session
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }
        
        model.addAttribute("page_title", "Read Share");
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("user",  userService.get((Long) session.getAttribute("user_id")));

        return "books/books.jsp";
    }

    @GetMapping("/books/new")
    public String showCreateBook (
        Model model,
        HttpSession session
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        model.addAttribute("page_title", "Add a New Book");
        model.addAttribute("user", userService.get((Long) session.getAttribute("user_id")));
        if (!model.containsAttribute("book")) {
            model.addAttribute("book", new Book());
        }

        return "books/create.jsp";
    }

    @PostMapping("/books")
    public String createBook(
        HttpSession session,
        @Valid @ModelAttribute("book") Book book,
        BindingResult result,
        RedirectAttributes redirAttr
    ) {

        if (session.getAttribute("user_id") == null || (Long) session.getAttribute("user_id") <= 0) { 
            return "redirect:/";
        }

        System.out.println(result);
        if (result.hasErrors()) {
            redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
            redirAttr.addFlashAttribute("book", book);
            return "redirect:/books/new";
        }

        bookService.create(book);

        return "redirect:/books";
    }
}
