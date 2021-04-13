package com.albo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.albo.repository.CharactersRepository;
import com.albo.repository.SincronizaRepository;

@ExtendWith(MockitoExtension.class)
public class MarvelServiceTests {
	
	@Mock
	private CharactersRepository charactersRepository;
	
	@Mock
	private SincronizaRepository syncRep;

	
	private MarvelService marvelService;
	
	@BeforeEach
	void setUp() {
		this.marvelService = new MarvelService(charactersRepository,syncRep);
	}
	
	@Test
	void getColaboratorsByCharacterNameTests() {
		//when
		this.marvelService.getColaboratorsByCharacterName("PanteraNegra");
		//then
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(this.charactersRepository).getCreatorsByCharactersName(argumentCaptor.capture());
		String heroeName = argumentCaptor.getValue();
		assertEquals("PanteraNegra", heroeName);
	}

	@Test
	void getInteractionByCharacterNameTests() {
		//when
		this.marvelService.getInteractionByCharacterName("PanteraNegra");
		//then
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(this.charactersRepository).getComicsByCharactersName(argumentCaptor.capture());
		verify(this.syncRep).getLastSync();
		String heroeName = argumentCaptor.getValue();
		assertEquals("PanteraNegra", heroeName);
	}
	
}