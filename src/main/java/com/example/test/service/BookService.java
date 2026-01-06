package com.example.test.service;

import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.test.repository.BookRepository;
import com.example.test.model.BookEntity;
import com.example.test.dto.CreateBookRequestDto;
import com.example.test.dto.UpdateBookRequestDto;
import com.example.test.dto.BookDto;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto createBook(CreateBookRequestDto requestDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(requestDto.getTitle());
        bookEntity.setAuthor(requestDto.getAuthor());
        bookEntity.setIsbn(requestDto.getIsbn());
        return toDto(bookRepository.save(bookEntity));
    }

    public BookDto getBook(long id) {
        // Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        // if (optionalBookEntity.isEmpty()) {
        // throw new RuntimeException("404 book not found");

        // }
        // return optionalBookEntity.get();
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found!"));
        return toDto(bookEntity);
    }

    public Page<BookDto> getBooks() {
        return bookRepository.findAll(PageRequest.of(0, 5))
                .map(this::toDto);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public BookDto updateBook(long id, UpdateBookRequestDto requestDto) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        if (optionalBookEntity.isEmpty()) {
            throw new RuntimeException("Book not found!");
        }
        BookEntity bookEntity = optionalBookEntity.get();
        bookEntity.setAuthor(requestDto.getAuthor());
        bookEntity.setTitle(requestDto.getTitle());
        bookEntity.setIsbn(requestDto.getIsbn());
        return toDto(bookRepository.save(bookEntity));
    }

    public BookDto toDto(BookEntity bookEntity) {
        BookDto dto = new BookDto();
        dto.setTitle(bookEntity.getTitle());
        dto.setAuthor(bookEntity.getAuthor());
        return dto;
    }
}
