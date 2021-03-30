package com.albo.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.dao.CharacterComicDAO;
import com.albo.dao.RespService1DAO;
import com.albo.repository.CharactersRepository;
import com.albo.repository.SincronizaRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class MarvelService {
	
	@Autowired
	private CharactersRepository charactersRepository;
	
	@Autowired
	private SincronizaRepository syncRep;

	private final String EDITOR = "editor";
	private final String WRITER = "writer";
	private final String COLORIST = "colorist";
	private final String PENCILLER = "penciller";
	
	private final String CHARACTER = "Character";
	private final String LAST_SYNC = "last_sync";
	
	public String getColaboratorsByCharacterName(String name) {
		
		JSONObject jsonResponse = new JSONObject();
		RespService1DAO respDAO = new RespService1DAO();
		List<String> listCreators = this.charactersRepository.getCreatorsByCharactersName(name);
		
		listCreators.forEach(creator->{
			List<String> line = Arrays.asList(creator.split(","));
			
			switch (line.get(2).toString()) {
			case EDITOR:
				respDAO.addEditor(line.get(1).toString());
				break;
				
			case WRITER:
				respDAO.addWriter(line.get(1).toString());
				break;
				
			case COLORIST:
				respDAO.addColorist(line.get(1).toString());
				break;
				
			case PENCILLER:
				respDAO.addPenciller(line.get(1).toString());
				break;

			default:
				break;
			}
		});
		jsonResponse.put(CHARACTER, name);
		jsonResponse.put(LAST_SYNC, new Date());
		jsonResponse.put(WRITER, respDAO.getWriter());
		jsonResponse.put(COLORIST,respDAO.getColorist());
		jsonResponse.put(EDITOR,respDAO.getEditor());
		jsonResponse.put(PENCILLER,respDAO.getPenciller());
		
		return jsonResponse.toString(); 
	}

	public String getInteractionByCharacterName(String name) {
		
		List<String> resp = this.charactersRepository.getComicsByCharactersName(name);
		List<CharacterComicDAO> modelListDAO = new ArrayList<CharacterComicDAO>();
		
		resp.forEach(charcter->{
			List<String> line = Arrays.asList(charcter.split(","));
			List<String> characters = this.charactersRepository.getCharactersBYComicsID(line.get(2) ) ;
			List<String> nombres = new ArrayList<String>();
			
			characters.forEach(ch->{
				List<String> lineChar = Arrays.asList(ch.split(","));
				nombres.add(lineChar.get(0));
			});
			modelListDAO.add(new CharacterComicDAO(line.get(1),nombres,Integer.parseInt(line.get(2))));
		});
		
		Map<String,List<String>> map = new HashMap<>();
		
		modelListDAO.forEach(model->{
			model.getChactersList().forEach(i->{
				if(map.get(i) != null) {
					List<String> aux = map.get(i);
					aux.add(model.getComic());
					map.put(i, aux);
				}else {
					List<String> aux = new ArrayList<String>();
					aux.add(model.getComic());
					map.put(i, aux);
				}
			});	
		});	
		
		List<String> sybcLast = this.syncRep.getLastSync();
		Gson gson = new Gson();
	    Type gsonType = new TypeToken<HashMap>(){}.getType();
	    String gsonString = gson.toJson(map,gsonType);
	    JSONObject respJ = new JSONObject();
	    respJ.put("result", gsonString);
	    respJ.put("last_sync", sybcLast.get(0));
	   
		return respJ.toString();
	}
}