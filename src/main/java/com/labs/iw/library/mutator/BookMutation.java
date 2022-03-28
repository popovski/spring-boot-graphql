package com.labs.iw.library.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.labs.iw.library.entity.Book;
import com.labs.iw.library.exception.BookNotFoundException;
import com.labs.iw.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BookMutation implements GraphQLMutationResolver {
	@Autowired
	private BookRepository bookRepository;

	public Book newBook(String title, String description) {
		Book book = new Book();

		book.setTitle(title);
		book.setDescription(description);

		bookRepository.save(book);
		return book;
	}

	public boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	public Book updateBook(String newTitle, String newDescription,Long id) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found",id));

		if(!Objects.isNull(newTitle)) {
			book.setTitle(newTitle);
		}

		if(!Objects.isNull(newDescription)) {
			book.setDescription(newDescription);
		}

		bookRepository.save(book);
		return book;
	}
}
