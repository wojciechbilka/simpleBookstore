package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.model.Person;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.PersonRepository;
import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class BookService {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findByOrderByTittleAsc();
    }

    public List<Book> getByTittle(String tittle) {
        return bookRepository.findByTittle(tittle);
    }

    public List<Book> getByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public boolean isBorrowed(Long id) {
        Optional<Book> book = bookRepository.findByIdAndBorrowerIsNotNull(id);
        return book.isPresent();
    }

    public void returnBook(Long id) {
        Optional<Book> optionalBook = getById(id);
        System.out.println(optionalBook);
        optionalBook.ifPresent(book -> {
            if(book.isBorrowed()) {
                Person person = book.getBorrower();
                person.getBooks().remove(book);
                personRepository.save(person);
                book.setBorrower(null);
                book.setAvailable(true);
                book.setBorrowingDate(null);
                bookRepository.save(book);
            }
        });
    }
}
