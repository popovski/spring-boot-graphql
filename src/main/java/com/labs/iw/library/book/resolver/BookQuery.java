package com.labs.iw.library.book.resolver;


import com.labs.iw.library.book.entity.Book;
import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;
import com.labs.iw.library.book.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class BookQuery implements GraphQLQueryResolver {
	@Autowired
	private BookRepository bookRepository;

	public Iterable<Book> findAllBooks(Integer pageNumber, Integer pageSize) {
		if (!Objects.isNull(pageNumber) && !Objects.isNull(pageSize)) {
			return bookRepository.findAll(PageRequest.of(pageNumber,pageSize));
		} else {
			return bookRepository.findAll();
		}
	}

	public Book findBookByUuid(String uuid) {
		return bookRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
	}

	public long countBooks() {
		return bookRepository.count();
	}
}
