package com.albo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.model.CharactersModel;
import com.albo.repository.CharactersRepository;

@Service
public class CharacterService {
	
	@Autowired
	private CharactersRepository characterRespository;
	
	
	public Iterable<CharactersModel> getAll(){
		return characterRespository.findAll();
	}

}
