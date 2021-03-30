package com.albo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albo.model.Character_Comics;

@Repository
public interface CharacterComicsRepository extends CrudRepository<Character_Comics, Long> {}