package com.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String tittle;
    private String author;
    private boolean available;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowingDate;
    @ManyToOne
    @JoinColumn(name = "person_id")
    @ToString.Exclude
    private Person borrower;

    public boolean isBorrowed() {
        return borrower != null;
    }
}
