package com.albo.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.albo.model.Character_Comics;
import com.albo.model.CharactersModel;
import com.albo.model.ComicsModel;
import com.albo.model.Creators;
import com.albo.model.CreatorsComics;
import com.albo.model.Sincroniza;
import com.albo.repository.CharacterComicsRepository;
import com.albo.repository.CharactersRepository;
import com.albo.repository.ComicsRepository;
import com.albo.repository.CreatorsComicsRepository;
import com.albo.repository.CreatorsRepository;
import com.albo.repository.SincronizaRepository;

@Service
public class SincronizarService {
	
	@Autowired
	private SincronizaRepository sincronizaRepository;
	
	@Autowired
	private CharactersRepository charactersRepository;
	
	@Autowired
	private CreatorsRepository creatorsRepository;
	
	@Autowired
	private ComicsRepository comicsRepository;
	
	@Autowired
	private CharacterComicsRepository charaComicRepository;
	
	@Autowired
	private CreatorsComicsRepository creatorsComicRepository;
	
	@Autowired
	private FormatBuild buildService;
	
	public void sincronizaDataBase(JSONObject request) {		
		JSONArray jsonComics = (JSONArray) request.get("comics");
		JSONArray jsonCharacters = (JSONArray) request.get("characteres");
		JSONArray jsonCreators = (JSONArray) request.get("creators");
		
		List<ComicsModel> listComics = this.buildService.buildComics(jsonComics);
		List<CharactersModel> listCharacters = this.buildService.buildCharacters(jsonCharacters);
		List<Creators> listCreators = this.buildService.buildCreators(jsonCreators);
		List<Character_Comics> listCharacterComicConection = this.buildService.buildCharacterComicConection(jsonCharacters);
		List<CreatorsComics> listCreatorsComicConection = this.buildService.buildCreatorsComicConection(jsonComics);
		
		this.comicsRepository.saveAll(listComics);
		this.charactersRepository.saveAll(listCharacters);
		this.creatorsRepository.saveAll(listCreators);
		this.charaComicRepository.saveAll(listCharacterComicConection);
		this.creatorsComicRepository.saveAll(listCreatorsComicConection);
		this.sincronizaRepository.save(new Sincroniza(new Date(), listCharacters.size(), listComics.size(), listCreators.size()));
	}
	
	public JSONArray getHistory() {	
		Iterable<Sincroniza> his = this.sincronizaRepository.findAll();
		JSONArray resp = new JSONArray();
		his.forEach(item->{
			resp.put(this.buildService.buildSincronizacion(item));
		});
		return resp;
	}

	public void setDatosPrueba() {
		this.setDatos();
	}
	
	private void setDatos() {
		this.charactersRepository.save(new CharactersModel("Heroe 1","htttps://",147852));
		this.charactersRepository.save( new CharactersModel("Heroe 2","htttps://",147853));
		this.charactersRepository.save(new CharactersModel("Heroe 3","htttps://",147854));
		
		this.comicsRepository.save(new ComicsModel("Comic teste 1","desc teste",741852));
		this.comicsRepository.save(new ComicsModel("Comic teste 2","desc teste",741851));
		this.comicsRepository.save(new ComicsModel("Comic teste 3","desc teste",741853));
		this.comicsRepository.save(new ComicsModel("Comic teste 4","desc teste",741857));
		
		this.creatorsRepository.save((new Creators("Creator 1",963852)));
		this.creatorsRepository.save((new Creators("Creator 2",963853)));
		this.creatorsRepository.save((new Creators("Creator 3",963854)));
		this.creatorsRepository.save((new Creators("Creator 4",963855)));
		this.creatorsRepository.save((new Creators("Creator 5",963856)));
		
		this.charaComicRepository.save(new Character_Comics(147852,741852));
		this.charaComicRepository.save(new Character_Comics(147852,741851));
		this.charaComicRepository.save(new Character_Comics(147853,741851));
		this.charaComicRepository.save(new Character_Comics(147854,741853));
		this.charaComicRepository.save(new Character_Comics(147854,741857));
		
		this.creatorsComicRepository.save(new CreatorsComics(963852,741852,"editor"));
		this.creatorsComicRepository.save(new CreatorsComics(963852,741851,"letterer"));
		this.creatorsComicRepository.save(new CreatorsComics(963853,741853,"editor"));		
		this.creatorsComicRepository.save(new CreatorsComics(963853,741857,"writer"));	
		
		this.creatorsComicRepository.save(new CreatorsComics(963854,741857,"colorist"));		
		this.creatorsComicRepository.save(new CreatorsComics(963855,741852,"colorist"));
	}

	@Scheduled(cron="1 0 * * * *")
	public void sincro() throws InterruptedException{
		
	}
}