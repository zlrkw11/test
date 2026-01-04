package com.example.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.BookEntity;
import com.example.test.repository.BookRepository;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(String title, String author, String isbn) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(title);
        bookEntity.setAuthor(author);
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }
}
