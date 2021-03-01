package com.bookstore.repository;

import com.bookstore.model.UserBookstore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserBookstoreRepository extends JpaRepository<UserBookstore, Long> {
    Optional<UserBookstore> findByUsername(String username);
}
