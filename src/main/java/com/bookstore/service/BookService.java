package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findByOrderByTittleAsc();
    }

    public List<Book> getByTittle(String tittle) {
        return bookRepository.findByTittle(tittle);
    }

    public List<Book> getByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
}
