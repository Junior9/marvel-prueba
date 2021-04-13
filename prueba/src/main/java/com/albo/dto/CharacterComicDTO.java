package com.albo.dto;

import java.util.List;

public class CharacterComicDTO {
	
	private String comic;
	private List<String> chactersList;
	private Integer comicId;
	
	public CharacterComicDTO(){}
	
	public CharacterComicDTO(String comic,List<String> chactersList,Integer comicId){
		this.comic = comic;
		this.chactersList = chactersList;
		this.comicId = comicId;
	}
	
	public String getComic() {
		return comic;
	}
	public List<String> getChactersList() {
		return chactersList;
	}
	public Integer getComicId() {
		return comicId;
	}
	

}
