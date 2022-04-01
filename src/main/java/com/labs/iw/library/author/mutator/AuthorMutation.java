package com.labs.iw.library.author.mutator;

import com.labs.iw.library.author.dto.AuthorDTO;
import com.labs.iw.library.author.entity.Author;
import com.labs.iw.library.author.repository.AuthorRepository;
import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AuthorMutation implements GraphQLMutationResolver {
	@Autowired
	private AuthorRepository authorRepository;

	public Author newAuthor(AuthorDTO authorDTO) {
		Author author = new Author();
		author.setFirstName(authorDTO.getFirstName());
		author.setLastName(authorDTO.getLastName());

		authorRepository.save(author);
		return author;
	}


	public boolean deleteAuthor(String uuid) {
		Optional<Author> author = authorRepository.findByUuid(uuid);

		if(author.isPresent()) {
			Author entity = author.get();
			authorRepository.delete(entity);
			return true;
		} else {
			throw new ResourceNotFoundException("Author not found");
		}
	}

	public Author updateAuthor(AuthorDTO authorDTO,String uuid) {
		Author author = authorRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Author not found"));

		if(!Objects.isNull(authorDTO.getFirstName())) {
			author.setFirstName(authorDTO.getFirstName());
		}

		if(!Objects.isNull(authorDTO.getLastName())) {
			author.setLastName(authorDTO.getLastName());
		}

		authorRepository.save(author);
		return author;
	}

}
