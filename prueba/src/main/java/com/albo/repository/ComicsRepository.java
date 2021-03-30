package com.albo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.ComicsModel;

@Repository
public interface ComicsRepository extends CrudRepository<ComicsModel, Long> {

}