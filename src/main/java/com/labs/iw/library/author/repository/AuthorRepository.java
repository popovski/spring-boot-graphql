package com.labs.iw.library.author.repository;

import com.labs.iw.library.author.dto.AuthorResponseDTO;
import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.author.repository.custom.AuthorCustomRepository;
import com.labs.iw.library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> , AuthorCustomRepository {
	Optional<Author> findByUuid(String uuid);
	List<Author> findAuthorsByBooksIn(List<Book> books);
}
