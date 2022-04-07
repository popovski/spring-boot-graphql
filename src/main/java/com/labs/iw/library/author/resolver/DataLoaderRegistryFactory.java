/**
 * 
 */
package com.labs.iw.library.author.resolver;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.labs.iw.library.author.dto.AuthorResponseDTO;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.author.repository.custom.impl.AuthorCustomRepositoryImpl;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	private DataLoader<Long, List<AuthorResponseDTO>> createAuthorDataLoader() {
		MappedBatchLoader<Long, List<AuthorResponseDTO>> customerMappedBatchLoader =
				(Set<Long> bookIdList) -> CompletableFuture.supplyAsync(() -> {
					List<AuthorResponseDTO> authors = authorRepository.findAuthorsByBookIds(bookIdList);

					Map<Long, List<AuthorResponseDTO>> groupByBookId =
							authors.stream().collect(Collectors.groupingBy(author -> author.getBookId()));

					return groupByBookId;
				});

		return DataLoader.newMappedDataLoader(customerMappedBatchLoader);
	}

}
