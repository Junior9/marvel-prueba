package com.albo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.Sincroniza;

@Repository
public interface SincronizaRepository extends CrudRepository<Sincroniza, Long> {
	
}
