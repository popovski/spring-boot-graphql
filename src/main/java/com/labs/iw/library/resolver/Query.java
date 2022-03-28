package com.labs.iw.library.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.labs.iw.library.entity.Application;
import com.labs.iw.library.entity.Book;
import com.labs.iw.library.repository.ApplicationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
	private ApplicationRepository applicationRepository;

	public Query(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

    public Iterable<Application> findAllApplications(Integer pageNumber, Integer pageSize) {
    	if (!Objects.isNull(pageNumber) && !Objects.isNull(pageSize)) {
			return applicationRepository.findAll(PageRequest.of(pageNumber,pageSize));
		} else {
    		return applicationRepository.findAll();
		}

    }
	public long countApplications() {
		return applicationRepository.count();
	}

	public List<Book> findAllStudents() {
		List<Book> bookList = new ArrayList<>();
		Book book = new Book();
		book.setTitle("Test1");
		book.setDescription("Test2");
		bookList.add(book);

		return bookList;
	}
}
