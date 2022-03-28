package com.labs.iw.library.repository;

import com.labs.iw.library.entity.Book;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	public Iterable<Book> findAll(Pageable pageable);
	public List<Book> findAll();
}
