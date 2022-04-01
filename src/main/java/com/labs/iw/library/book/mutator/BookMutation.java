package com.labs.iw.library.book.mutator;

import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.book.dto.BookDTO;
import com.labs.iw.library.book.entity.Book;
import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;
import com.labs.iw.library.book.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class BookMutation implements GraphQLMutationResolver {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public Book newBook(BookDTO bookDTO,List<String> authorUuids) {
		Book book = new Book();

		book.setTitle(bookDTO.getTitle());
		book.setDescription(bookDTO.getDescription());

		if(!CollectionUtils.isEmpty(authorUuids)) {
			List<Author> authors = new ArrayList<>();

			for(String uuid : authorUuids) {
				Author author = authorRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
				authors.add(author);
			}

			book.setAuthors(authors);
		}

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
			throw new ResourceNotFoundException("Book not found");
		}
	}

	public Book updateBook(BookDTO bookDTO,String uuid) {
		Book book = bookRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

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
