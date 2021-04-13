package com.albo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.albo.model.Character_Comics;

@DataJpaTest
class CharacterComicsRepositoryTests {

	@Autowired
	private CharacterComicsRepository charactersRespository;
	
	@Test
	void selectCharacter() {
		//given
		Character_Comics character = new Character_Comics(1857,885);
		this.charactersRespository.save(character);
		//when
		Character_Comics characterResp = this.charactersRespository.findByMarvel_Characters_Id(1857L);
	
		//then
		assertEquals(Integer.parseInt("1857"),characterResp.getMarvelCharactersId() );
	}
	
	@Test
	void delteCharacter() {
		 List<Character_Comics> resultList = new ArrayList<Character_Comics>();
		//given
		this.charactersRespository.save( new Character_Comics(1857,885));
		this.charactersRespository.save( new Character_Comics(1852,825));
		//when
		this.charactersRespository.deleteAll();
		Iterable<Character_Comics> res = this.charactersRespository.findAll();
		res.forEach(resultList::add);
		//then
		assertEquals(0,resultList.size());
	}

}
