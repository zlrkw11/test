package com.example.test.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.test.repository.BookRepository;
import com.example.test.model.BookEntity;
import com.example.test.dto.CreateBookRequestDto;;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(CreateBookRequestDto requestDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(requestDto.getTitle());
        bookEntity.setAuthor(requestDto.getAuthor());
        bookEntity.setIsbn(requestDto.getIsbn());
        return bookRepository.save(bookEntity);
    }

    public BookEntity getBook(long id) {
        // Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        // if (optionalBookEntity.isEmpty()) {
        // throw new RuntimeException("404 book not found");

        // }
        // return optionalBookEntity.get();
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found!"));
    }

}
