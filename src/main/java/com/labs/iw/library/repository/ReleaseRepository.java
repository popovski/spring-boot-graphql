package com.labs.iw.library.repository;

import com.labs.iw.library.entity.Release;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Long> {
}