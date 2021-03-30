package com.albo.dao;

import java.util.List;

public class CharacterComicDAO {
	
	private String comic;
	private List<String> chactersList;
	private Integer comicId;
	
	public CharacterComicDAO(){}
	
	public CharacterComicDAO(String comic,List<String> chactersList,Integer comicId){
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
