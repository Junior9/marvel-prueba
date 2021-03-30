package com.albo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.CharactersModel;

@Repository
public interface CharactersRepository extends CrudRepository<CharactersModel, Long> {
	
	@Query(value = "SELECT c.name , cr.full_name , crc.role_creator  from characters c INNER JOIN characters_comics cc ON c.marvel_Id = cc.marvel_characters_id  INNER JOIN comics co ON cc.marvel_comics_id = co.marvel_Id INNER JOIN creators_comics crc ON crc.marvel_comics_id = co.marvel_Id  INNER JOIN creators cr ON cr.marvel_Id = crc.marvel_creators_id where c.name =?1", nativeQuery = true)
	public List<String> getCreatorsByCharactersName(String name);
	
	@Query(value = "SELECT c.name , cr.full_name , crc.role_creator  from characters c INNER JOIN characters_comics cc ON c.marvel_Id = cc.marvel_characters_id  INNER JOIN comics co ON cc.marvel_comics_id = co.marvel_Id INNER JOIN creators_comics crc ON crc.marvel_comics_id = co.marvel_Id  INNER JOIN creators cr ON cr.marvel_Id = crc.marvel_creators_id where c.name =?1", nativeQuery = true)
	public List<String> getCharactersWithComicsByRelacion(String name);
}