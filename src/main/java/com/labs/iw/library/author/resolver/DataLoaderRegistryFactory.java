/**
 * 
 */
package com.labs.iw.library.author.resolver;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.book.entity.Book;

/**
 * @author nikola.popovski
 *
 */
@Component
public class DataLoaderRegistryFactory {
	@Autowired
	AuthorRepository authorRepository;

	public static final String AUTHOR_DATA_LOADER = "AUTHOR_DATA_LOADER";

	public DataLoaderRegistry newDataLoaderRegistry() {
		DataLoaderRegistry registry = new DataLoaderRegistry();
		registry.register(AUTHOR_DATA_LOADER, createAuthorDataLoader());
		return registry;
	}

	private DataLoader<Long, Author> createAuthorDataLoader() {
		return DataLoader.newDataLoader((List<Long> bookIdList) -> CompletableFuture.supplyAsync(() -> {
			// Batch request the Author for book ids
			List<Author> authorList = authorRepository.findAllById(bookIdList);

			// Futures are correlated and completed based on the ordered list (position)
			return authorList;
		}));
	}

}
