package com.albo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.Creators;

@Repository
public interface  CreatorsRepository extends CrudRepository<Creators, Long> {

}
