package com.labs.iw.library.repository;

import com.labs.iw.library.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
	public Page<Application> findAll(Pageable pageable);
	public List<Application> findAll();
}
