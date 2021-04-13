package com.albo.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.albo.model.CharactersModel;
import com.albo.service.CharacterService;
import com.albo.service.MarvelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MarvelController {
	
	@Autowired
	private MarvelService marvelService;
	
	
	@Autowired
	private CharacterService characterService;
	
	
	public MarvelController(MarvelService marvelService) {
		this.marvelService = marvelService;
	}

	@GetMapping("/marvel/colaborators/{name}")
	@ResponseBody
	public ResponseEntity<String> getColaboratorsByCharacterName(@PathVariable(name="name") String name) {
		String jsonResponse = this.marvelService.getColaboratorsByCharacterName(name);
		ResponseEntity<String> response = new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/marvel/characters/{name}")
	public ResponseEntity<String> geListCharactersInteractionByCharactersName(@PathVariable(name="name") String name) {
		String jsonResponse = this.marvelService.getInteractionByCharacterName(name);
		ResponseEntity<String> response = new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/marvel/characters")
	public ResponseEntity<String> geListCharacters() {
		List<CharactersModel> chartList = (List<CharactersModel>) this.characterService.getAll();
		JSONArray responseArrayJson = new JSONArray();
		
		chartList.forEach(character->{
			responseArrayJson.put(new JSONObject().
							put("name", character.getName()).
							put("id", character.getId()).
							put("resourceURI", character.getResourceURI()).
							put("marvel_Id", character.getMarvel_Id()));
		});
	
		ResponseEntity<String> response = new ResponseEntity<String>(responseArrayJson.toString(), HttpStatus.OK);
		return response;
	}
}