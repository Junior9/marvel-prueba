package com.albo.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.albo.model.Character_Comics;
import com.albo.model.CharactersModel;
import com.albo.model.ComicsModel;
import com.albo.model.Creators;
import com.albo.model.CreatorsComics;
import com.albo.model.Sincroniza;

@Service
public class FormatBuild {
	
	private final Integer ULR_CHAR_SIZE = 43;
	private final Integer ULR_CREATOR_SIZE = 45;
	
	public List<ComicsModel> buildComics(JSONArray comics){
		List<ComicsModel> list = new ArrayList<ComicsModel>();
		if(comics != null && comics.length() > 0) {
			comics.forEach(item -> {
				JSONObject json = new JSONObject(item.toString());
			   list.add(new ComicsModel(json));
			});
		}
		return list;
	}

	public List<CharactersModel> buildCharacters(JSONArray characters) {
		List<CharactersModel> list = new ArrayList<CharactersModel>();
		if(characters != null && characters.length() > 0) {
			characters.forEach(item -> {
				JSONObject json = new JSONObject(item.toString());
			   list.add(new CharactersModel(json));
			});
		}
		return list;
	}

	public List<Creators> buildCreators(JSONArray jsonCreators) {
		
		List<Creators> list = new ArrayList<Creators>();
		if(jsonCreators != null && jsonCreators.length() > 0) {
			jsonCreators.forEach(item -> {
				JSONObject json = new JSONObject(item.toString());
			   list.add(new Creators(json));
			});
		}
		return list;
	}
	
	public JSONObject buildSincronizacion(Sincroniza item) {
		JSONObject json = new JSONObject();
		json.put("date",item.getDate());
		json.put("cantidad", item.getTotal());
		return json;
	}

	public List<Character_Comics> buildCharacterComicConection(JSONArray listCharacters) {
		
		List<Character_Comics> resul = new ArrayList<Character_Comics>();
		listCharacters.forEach(character->{
			JSONObject json = new JSONObject(character.toString());
			JSONObject jsonComics = (JSONObject) json.get("comics");
			JSONArray jsonComicsItens = (JSONArray) jsonComics.get("items");
			Integer characterId = json.getInt("id");
			
			jsonComicsItens.forEach(comic->{
				JSONObject jsonComic = new JSONObject(comic.toString());
				resul.add(new Character_Comics(characterId, Integer.parseInt(this.getCharacterIdByUrl(jsonComic.getString("resourceURI")))  ));
			});
		});
		return resul;
	}
	
	public List<CreatorsComics> buildCreatorsComicConection(JSONArray jsonCreators) {	
		
		List<CreatorsComics> resul = new ArrayList<CreatorsComics>();
		jsonCreators.forEach(creatorObj->{
			JSONObject jsonCreator = new JSONObject(creatorObj.toString());
			JSONObject creator = (JSONObject) jsonCreator.get("creators");
			Integer comicId = jsonCreator.getInt("id");
			JSONArray jsonCreatorsItens = (JSONArray) creator.get("items");
			
			jsonCreatorsItens.forEach(comic->{
				JSONObject jsonComic = new JSONObject(comic.toString());    
				resul.add(new CreatorsComics(Integer.parseInt(this.getCreatorIdByUrl(jsonComic.getString("resourceURI"))), comicId,jsonComic.getString("role")));
			});
		});		
		return resul;
	}
	
	public String getCreatorIdByUrl(String url) {
		return url.substring(ULR_CREATOR_SIZE, url.toString().length());
	}
	
	public String getCharacterIdByUrl(String url) {
		return url.substring(ULR_CHAR_SIZE, url.toString().length());
	}
}