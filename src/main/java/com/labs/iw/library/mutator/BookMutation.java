package com.labs.iw.library.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.labs.iw.library.entity.Book;
import com.labs.iw.library.exception.BookNotFoundException;
import com.labs.iw.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

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

	public boolean deleteBook(String uuid) {
		Optional<Book> book = bookRepository.findByUuid(uuid);
		if(book.isPresent()) {
			Book entity = book.get();
			bookRepository.delete(entity);
			return true;
		} else {
			throw new BookNotFoundException("Book not found");
		}
	}

	public Book updateBook(String newTitle, String newDescription,String uuid) {
		Book book = bookRepository.findByUuid(uuid).orElseThrow(() -> new BookNotFoundException("Book not found"));

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
