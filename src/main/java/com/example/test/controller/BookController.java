package com.example.test.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.test.model.BookEntity;
import com.example.test.service.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test.dto.CreateBookRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookEntity createBook(@RequestBody CreateBookRequestDto requestDto) {
        return bookService.createBook(requestDto);
    }

    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @GetMapping
    public List<BookEntity> getBooks() {
        return bookService.getBooks();
    }
}
