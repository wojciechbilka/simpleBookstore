package com.bookstore.controller;

import com.bookstore.model.Address;
import com.bookstore.model.Book;
import com.bookstore.model.Person;
import com.bookstore.model.UserBookstore;
import com.bookstore.service.BookService;
import com.bookstore.service.PersonService;
import com.bookstore.service.UserBookstoreService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Data
@RequiredArgsConstructor
public class BookstoreController {

    private final BookService bookService;
    private final UserBookstoreService userBookstoreService;
    private final PersonService personService;

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);

        UserBookstore user = (UserBookstore) authentication.getPrincipal();
        Integer booksCount = user.getPerson().getBooks().size();
        model.addAttribute("personId", user.getPerson().getId());
        model.addAttribute("booksCount", booksCount);
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

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam("book_id") Long bookId, Authentication authentication) {
        if(!bookService.isBorrowed(bookId)) {
            bookService.deleteById(bookId);
        }
        return "redirect:/";
    }

    @PostMapping("/confirmReturnBook")
    public String confirmReturnBook(@RequestParam("book_id") Long bookId, Authentication authentication) {
        bookService.returnBook(bookId);
        return "redirect:/";
    }

    @GetMapping("/myBooks")
    public String myBooks(Model model, Authentication authentication) {
        UserBookstore user = (UserBookstore) authentication.getPrincipal();
        List<Book> books = user.getPerson().getBooks();
        model.addAttribute("myBooks", books);
        return "shelf/my_books";
    }

    @GetMapping("/register")
    public String register(Model model, Authentication authentication) {
        UserBookstore userBookstore = new UserBookstore();
        Person person = new Person();
        person.setAddress(new Address());
        userBookstore.setPerson(person);
        model.addAttribute("userBookstore", userBookstore);
        return "/registration_form";
    }

    @PostMapping("/saveUserBookstore")
    public String saveUserBookstore(@ModelAttribute UserBookstore userBookstore, Authentication authentication) {
        userBookstoreService.save(userBookstore);
        System.out.println(userBookstore);
        return "redirect:/";
    }
}
