package com.albo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.Sincroniza;

@Repository
public interface SincronizaRepository extends CrudRepository<Sincroniza, Long> {
	
	@Query(value = "SELECT date FROM SINCRONIZACIONES  ORDER BY DATE DESC  LIMIT 1 ;", nativeQuery = true)
	public List<String> getLastSync();
	
}
