package com.labs.iw.library.author.repository.custom.impl;

import com.labs.iw.library.author.dto.AuthorResponseDTO;
import com.labs.iw.library.author.repository.custom.AuthorCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Repository
public class AuthorCustomRepositoryImpl implements AuthorCustomRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<AuthorResponseDTO> findAuthorsByBookIds(Set<Long> bookIdList) {
		TypedQuery<AuthorResponseDTO> namedQuery =
				entityManager.createNamedQuery("AuthorDTO.findAuthorsByBookIds", AuthorResponseDTO.class);
		namedQuery.setParameter(1,bookIdList);
		return namedQuery.getResultList();
	}
}
