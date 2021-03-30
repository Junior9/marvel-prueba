package com.albo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="creators")
public class Creators {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="marvel_Id")
	private Integer marvel_Id;
	
	public Creators(JSONObject jsonCreator){
		if(jsonCreator.has("fullName")) {
			this.fullName = jsonCreator.getString("fullName");
		}else {
			this.fullName = "";
		}
		this.marvel_Id = jsonCreator.getInt("id");
	}
	
	public Creators(String fullName,Integer id){
		this.fullName = fullName;
		this.marvel_Id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	
	public Integer getMarvelId() {
		return this.marvel_Id;
	}

}
