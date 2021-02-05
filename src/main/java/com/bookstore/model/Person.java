package com.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    @OneToMany(
            mappedBy = "borrower",
            cascade = CascadeType.ALL
    )
    private List<Book> books;
}
