package com.labs.iw.library.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.labs.iw.library.entity.Book;
import com.labs.iw.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookQuery implements GraphQLQueryResolver {
	@Autowired
	private BookRepository bookRepository;

	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public long countBooks() {
		return bookRepository.count();
	}
}
