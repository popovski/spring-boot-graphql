package com.labs.iw.library.repository;

import com.labs.iw.library.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
