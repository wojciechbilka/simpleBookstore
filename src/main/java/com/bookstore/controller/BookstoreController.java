package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Data
@RequiredArgsConstructor
public class BookstoreController {

    private final BookService bookService;

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        //TODO Add pagination for the list
        return "shelf/bookList";
    }

    /*@PostMapping("/editBook")
    public String editBook(Model model, @RequestParamAuthentication authentication) {
        model.addAttribute("book", )
    }*/

    @PostMapping("/addBook")
    public String addBook(Model model, @ModelAttribute Book book, Authentication authentication) {
        return "shelf/book_form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute Book book, Authentication authentication) {
        bookService.save(book);
        return "redirect:/";
    }
}
