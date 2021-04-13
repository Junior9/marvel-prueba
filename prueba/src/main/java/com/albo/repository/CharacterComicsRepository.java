package com.albo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.Character_Comics;

@Repository
public interface CharacterComicsRepository extends CrudRepository<Character_Comics, Long> {
	
	@Query(value = "SELECT * from characters_comics WHERE marvel_characters_id = ?1" , nativeQuery = true)
	public Character_Comics findByMarvel_Characters_Id(Long id);
}