package com.example.test.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.test.model.BookEntity;
import com.example.test.service.BookService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.test.dto.CreateBookRequestDto;
import com.example.test.dto.UpdateBookRequestDto;
import com.example.test.dto.BookDto;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public BookDto createBook(@RequestBody CreateBookRequestDto requestDto) {
        return bookService.createBook(requestDto);
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @GetMapping
    public Page<BookDto> getBooks(Pageable pageable) {
        return bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public void DeleteBook(@PathVariable long id) {
        System.out.println("Removed book - id: " + id);
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void UpdateBook(@PathVariable long id, @Valid @RequestBody UpdateBookRequestDto updateBookRequestDto) {
        bookService.updateBook(id, updateBookRequestDto);
    }
}
