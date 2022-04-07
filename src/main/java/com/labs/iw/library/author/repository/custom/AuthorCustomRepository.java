package com.labs.iw.library.author.repository.custom;

import com.labs.iw.library.author.dto.AuthorResponseDTO;

import java.util.List;
import java.util.Set;

public interface AuthorCustomRepository {
	public List<AuthorResponseDTO> findAuthorsByBookIds(Set<Long> bookIdList);
}
