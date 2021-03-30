package com.albo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuildServiceTests {
	
	@Autowired
	private FormatBuild buildService;
	
	@Test
	void buildComicsReciveNullValueTests() {
		assertEquals(0,this.buildService.buildComics(null).size() );
	}
	
	@Test
	void buildCreatorReciveNullValueTests() {
		assertEquals(0,this.buildService.buildCreators(null).size() );
	}
	
	@Test
	void buildCharactersReciveNullValueTests() {
		assertEquals(0,this.buildService.buildCharacters(null).size() );
	}
	
	@Test
	void getCreatorIdByUrlTests() {
		String url = "http://gateway.marvel.com/v1/public/creators/10021";
		assertEquals("10021", this.buildService.getCreatorIdByUrl(url));
	}
	
	@Test
	void getCharacterIdByUrlTests() {
		String url = "http://gateway.marvel.com/v1/public/comics/21366";
		assertEquals("21366", this.buildService.getCharacterIdByUrl(url));
	}

}
