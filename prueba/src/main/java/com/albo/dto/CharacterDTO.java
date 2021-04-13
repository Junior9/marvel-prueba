package com.albo.dto;

import java.util.List;

public class CharacterDTO {

	private String name;
	private List<String> comics;
	
	
	public CharacterDTO(String name,List<String> comics) {
		this.name = name;
		this.comics = comics;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getComics() {
		return comics;
	}
	public void setComics(List<String> comics) {
		this.comics = comics;
	}
	
	
}
