package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
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
