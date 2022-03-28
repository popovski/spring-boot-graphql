package com.labs.iw.library.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.labs.iw.library.entity.Book;
import com.labs.iw.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
