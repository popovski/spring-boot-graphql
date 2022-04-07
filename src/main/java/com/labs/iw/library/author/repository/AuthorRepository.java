package com.labs.iw.library.author.repository;

import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
	Optional<Author> findByUuid(String uuid);
	List<Author> findAuthorsByBooksIn(List<Book> books);
	
	@Query(value = "select a.id as id1_0_, a.created_on as created_2_0_, "
			+ "a.uuid as uuid3_0_, a.first_name as first_na4_0_, a.last_name as last_nam5_0_"
			+ ", book2_.id as bookId "
			+ " FROM author a "
			+ " LEFT OUTER JOIN book_authors books1_ on a.id=books1_.authors_id  "
			+ " LEFT OUTER JOIN book book2_ on books1_.books_id=book2_.id "
			+ " WHERE book2_.id in (?1)", nativeQuery=true)
	List<Author> findAuthorsByBookIds(Set<Long> bookIdList);
}
