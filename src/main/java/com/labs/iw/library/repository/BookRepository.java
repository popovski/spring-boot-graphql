package com.labs.iw.library.repository;

import com.labs.iw.library.entity.Book;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Long>, CrudRepository<Book, Long> {

}
