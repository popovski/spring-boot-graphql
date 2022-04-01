package com.labs.iw.library.book.repository;

import com.labs.iw.library.book.entity.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, CrudRepository<Book, Long> {
		Optional<Book> findByUuid(String uuid);
}
