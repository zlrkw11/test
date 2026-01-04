package com.example.test.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.test.model.BookEntity;
import com.example.test.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.test.dto.CreateBookRequestDto;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public BookEntity createBook(@RequestBody CreateBookRequestDto requestDto) {
        return bookService.createBook(requestDto);
    }
}
