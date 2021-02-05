package com.bookstore.repository;

import com.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByOrderByTittleAsc();

    @Query("SELECT u FROM Book u WHERE u.tittle = :tittle")
    List<Book> findByTittle(@Param("tittle") String tittle);

    @Query("SELECT u FROM Book u WHERE u.author = :author")
    List<Book> findByAuthor(@Param("author") String author);
}
