package com.albo.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.albo.model.CharactersModel;
import com.albo.repository.CharactersRepository;
import com.albo.service.MarvelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MarvelController {
	
	@Autowired
	private MarvelService marvelService;
	
	@Autowired
	private CharactersRepository charRespository;

	@GetMapping("/marvel/colaborators/{name}")
	@ResponseBody
	public String getColaboratorsByCharacterName(@PathVariable(name="name") String name) {
		return this.marvelService.getColaboratorsByCharacterName(name);
	}
	
	@GetMapping("/marvel/characters/{name}")
	public String geListCharactersInteractionByCharactersName(@PathVariable(name="name") String name) {
		return this.marvelService.getInteractionByCharacterName(name);
	}
	
	@GetMapping("/marvel/characters")
	public String geListCharacters() {
		List<CharactersModel> chartList = (List<CharactersModel>) this.charRespository.findAll();
		JSONArray response = new JSONArray();
		
		chartList.forEach(character->{
			response.put(new JSONObject().
							put("name", character.getName()).
							put("id", character.getId()).
							put("resourceURI", character.getResourceURI()).
							put("marvel_Id", character.getMarvel_Id()));
		});
		
		return response.toString();
	}
}