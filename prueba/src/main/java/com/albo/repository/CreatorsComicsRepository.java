package com.albo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.CreatorsComics;

@Repository
public interface CreatorsComicsRepository extends CrudRepository<CreatorsComics, Long> {

}
