package com.example.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequestDto {
    private String title;
    private String author;
    private String isbn;

}
