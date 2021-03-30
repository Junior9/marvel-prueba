package com.albo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="comics")
public class ComicsModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="decription")
	private String description;
	
	@Column(name="marvel_Id")
	private Integer marvel_Id;
	
	public ComicsModel(String title,String description,Integer marvel_id){
		this.title = title;
		this.description = description;
		this.marvel_Id = marvel_id;
	}
	
	public ComicsModel(JSONObject jsonComic){
		if(jsonComic.has("description")) {
			this.title = jsonComic.getString("title");
		}else {
			this.title = "";
		}
		
		if(jsonComic.has("description") && !jsonComic.get("description").equals(""))  {
			//this.description = jsonComic.getString("description");
			this.description= "";
		}else {
			this.description= "";
		}
		
		this.marvel_Id = jsonComic.getInt("id");
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Integer getMarvelId() {
		return this.marvel_Id;
	}

}