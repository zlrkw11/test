package com.example.test.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String isbn;

}
