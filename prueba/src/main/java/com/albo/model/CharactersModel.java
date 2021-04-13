package com.albo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

import lombok.ToString;

@Entity
@Table(name="characters")
@ToString
public class CharactersModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="resourceURI")
	private String resourceURI;
	
	@Column(name="marvel_Id")
	private Integer marvel_Id;
	
	public CharactersModel(){}
	
	public CharactersModel(String name,String resource,Integer idMarvel){
		this.name = name;
		this.resourceURI = resource;
		this.marvel_Id = idMarvel;
	}	
	
	public CharactersModel(JSONObject jsonCharacters){
		
		if(jsonCharacters.has("name")) {
			this.name = jsonCharacters.getString("name");
		}else {
			this.name = "";
		}
		
		if(jsonCharacters.has("resourceURI")) {
			this.resourceURI = jsonCharacters.getString("resourceURI");
		}else {
			this.resourceURI = "";
		}

		this.marvel_Id = jsonCharacters.getInt("id");
	}
	

	public String getName() {
		return this.name;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getResourceURI() {
		return this.resourceURI;
	}
	
	public Integer getMarvel_Id() {
		return this.marvel_Id;
	}
}
