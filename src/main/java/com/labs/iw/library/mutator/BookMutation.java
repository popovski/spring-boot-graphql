package com.labs.iw.library.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.labs.iw.library.dto.BookDTO;
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

	public Book newBook(BookDTO bookDTO) {
		Book book = new Book();

		book.setTitle(bookDTO.getTitle());
		book.setDescription(bookDTO.getDescription());

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

	public Book updateBook(BookDTO bookDTO,String uuid) {
		Book book = bookRepository.findByUuid(uuid).orElseThrow(() -> new BookNotFoundException("Book not found"));

		if(!Objects.isNull(bookDTO.getTitle())) {
			book.setTitle(bookDTO.getTitle());
		}

		if(!Objects.isNull(bookDTO.getDescription())) {
			book.setDescription(bookDTO.getDescription());
		}

		bookRepository.save(book);
		return book;
	}
}
