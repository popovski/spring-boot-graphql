package com.labs.iw.library.author.repository;

import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
	Optional<Author> findByUuid(String uuid);
	List<Author> findAuthorsByBooksIn(List<Book> books);
}
