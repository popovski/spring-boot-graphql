package com.labs.iw.library.author.resolver;

import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.book.entity.Book;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Component
public class AuthorResolver implements GraphQLResolver<Book> {
	@Autowired
	AuthorRepository authorRepository;
//
//	public CompletableFuture<List<Author>> authors(Book book) {
//		return CompletableFuture.supplyAsync(() -> authorRepository.findAuthorsByBooksIn(Arrays.asList(book)));
//	}

	  public CompletableFuture<List<Author>> authors(Book book, DataFetchingEnvironment environment) {
		    // Retrieve the Author dataloader
		    DataLoader<Long, List<Author>> authorDataLoader = environment.getDataLoader(DataLoaderRegistryFactory.AUTHOR_DATA_LOADER);
		    // Load the stock id into the batch dataloader ...
		    return authorDataLoader.load(book.getId());
		  }
	
}
