package com.albo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.albo.enuns.CreatorType;
import com.albo.service.MarvelService;

public class MarvelControllerTests {
	
	@Test
	void getColaboratorsByCharacterNameTests() throws Exception {
		
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("Character", "PanteraNegra");
		jsonResponse.put("last_sync", new Date());
		jsonResponse.put(CreatorType.WRITERS.toString(), Arrays.asList("Writer1"));
		jsonResponse.put(CreatorType.COLORISTS.toString(),Arrays.asList("COLORISTS"));
		jsonResponse.put(CreatorType.EDITOR.toString(),Arrays.asList("EDITOR"));
		jsonResponse.put(CreatorType.PENCIELLER.toString(),Arrays.asList("PENCIELLER"));
		
		MarvelService marvelService = Mockito.mock(MarvelService.class);
		when(marvelService.getColaboratorsByCharacterName("PanteraNegra")).thenReturn(jsonResponse.toString());
		
		MarvelController marvelController = new MarvelController(marvelService);
		ResponseEntity<String> resp = marvelController.getColaboratorsByCharacterName("PanteraNegra");
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		
	}
	
	
	

}
