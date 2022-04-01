package com.labs.iw.library.author.resolver;

import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthorQuery implements GraphQLQueryResolver {
	@Autowired
	private AuthorRepository authorRepository;

	public Iterable<Author> findAllAuthors(Integer pageNumber,Integer pageSize) {
		if (!Objects.isNull(pageNumber) && !Objects.isNull(pageSize)) {
			return authorRepository.findAll(PageRequest.of(pageNumber,pageSize));
		} else {
			return authorRepository.findAll();
		}
	}

	public Author findAuthorByUuid(String uuid) {
		return authorRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
	}

	public long countAuthors() {
		return authorRepository.count();
	}
}
