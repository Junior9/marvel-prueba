package com.albo.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.dao.RespService1DAO;
import com.albo.repository.CharactersRepository;

@Service
public class MarvelService {

	@Autowired
	private CharactersRepository charactersRepository;
	
	public String getColaboratorsByCharacterName(String name) {
		
		JSONObject jsonResponse = new JSONObject();
		RespService1DAO respDAO = new RespService1DAO();
		List<String> listCreators = this.charactersRepository.getCreatorsByCharactersName(name);
		
		System.out.println(listCreators.size());
		
		listCreators.forEach(creator->{
			List<String> line = Arrays.asList(creator.split(","));
			
			switch (line.get(2).toString()) {
			case "editor":
				respDAO.addEditor(line.get(1).toString());
				break;
				
			case "writer":
				respDAO.addWriter(line.get(1).toString());
				break;
				
			case "colorist":
				respDAO.addColorist(line.get(1).toString());
				break;
				
			case "penciller":
				respDAO.addPenciller(line.get(1).toString());
				break;

			default:
				break;
			}
		});
		jsonResponse.put("Character", name);
		jsonResponse.put("last_sync", new Date());
		jsonResponse.put("writers", respDAO.getWriter());
		jsonResponse.put("colorists",respDAO.getColorist());
		jsonResponse.put("editor",respDAO.getEditor());
		jsonResponse.put("penciller",respDAO.getPenciller());
		
		return jsonResponse.toString(); 
	}

	public String getInteractionByCharacterName(String name) {
		
		List<String> resp = this.charactersRepository.getCharactersWithComicsByRelacion(name);
		
		System.out.println(resp);
		
		
		
		return new JSONObject().put("resul","OK").toString();
	}

}