package com.bookstore.service;

import com.bookstore.model.Person;
import com.bookstore.repository.PersonRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findByOrderByNameDesc();
    }
}
