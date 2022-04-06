package com.labs.iw.library.book.resolver;

import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.book.entity.Book;
import com.labs.iw.library.book.repository.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Component
public class BookResolver implements GraphQLResolver<Author> {
	@Autowired
	BookRepository bookRepository;

	public CompletableFuture<List<Book>> books(Author author) {
		return CompletableFuture.supplyAsync(() -> bookRepository.findBooksByAuthorsIn(Arrays.asList(author)));
	}

}
