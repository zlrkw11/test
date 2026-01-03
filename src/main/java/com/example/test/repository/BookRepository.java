package com.example.test.repository;

import com.example.test.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
