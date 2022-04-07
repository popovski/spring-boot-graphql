package com.labs.iw.library.author.resolver;

import com.labs.iw.library.author.dto.AuthorResponseDTO;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.book.entity.Book;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Component
public class AuthorResolver implements GraphQLResolver<Book> {
	@Autowired
	AuthorRepository authorRepository;


	public CompletableFuture<List<AuthorResponseDTO>> authors(Book book, DataFetchingEnvironment environment) {
		// Retrieve the Author dataloader
		DataLoader<Long, List<AuthorResponseDTO>> authorDataLoader =
				environment.getDataLoader(DataLoaderRegistryFactory.AUTHOR_DATA_LOADER);
		// Load the book id into the batch dataloader ...
		return authorDataLoader.load(book.getId());
	}

}
