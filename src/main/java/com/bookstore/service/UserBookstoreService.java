package com.bookstore.service;

import com.bookstore.model.UserBookstore;
import com.bookstore.repository.UserBookstoreRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UserBookstoreService implements UserDetailsService {

    private final UserBookstoreRepository userBookstoreRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserBookstore> userOptional =
                userBookstoreRepository.findByUsername(username);
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public UserBookstore save(UserBookstore userBookstore) {
        return userBookstoreRepository.save(userBookstore);
    }
}
