package com.example.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.BookEntity;
import com.example.test.repository.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.test.dto.CreateBookRequestDto;;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/books")
    public BookEntity createBook(@RequestBody CreateBookRequestDto requestDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(requestDto.getTitle());
        bookEntity.setAuthor(requestDto.getAuthor());
        bookEntity.setIsbn(requestDto.getIsbn());
        return bookRepository.save(bookEntity);
    }
}
