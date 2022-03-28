package com.labs.iw.library.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.labs.iw.library.entity.Application;
import com.labs.iw.library.entity.Book;
import com.labs.iw.library.exception.ApplicationNotFoundException;
import com.labs.iw.library.repository.ApplicationRepository;
import com.labs.iw.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookMutation implements GraphQLMutationResolver {
	@Autowired
	private BookRepository studentRepository;

	public Book newBook(String title, String description) {
		Book book = new Book();

		book.setTitle(title);
		book.setDescription(description);

		studentRepository.save(book);
		return book;
	}
}
