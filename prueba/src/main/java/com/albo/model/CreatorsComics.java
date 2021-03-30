package com.albo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creators_comics")
public class CreatorsComics {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="marvel_creators_id")
	private Integer marvel_creators_id;
	
	@Column(name="marvel_comics_id")
	private Integer marvel_comics_id;
	
	@Column(name="role_creator")
	private String role_creator;
	
	public CreatorsComics() {}
	
	public CreatorsComics(Integer marvel_creators_id, Integer marvel_comics_id, String role_creator) {
		this.marvel_creators_id = marvel_creators_id;
		this.marvel_comics_id = marvel_comics_id;
		this.role_creator = role_creator;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Integer getMarvelComicsId() {
		return this.marvel_comics_id;
	}

	public Integer getMarvelCreatorsId() {
		return this.marvel_creators_id;
	}
	
	public String getRoleCreator() {
		return this.role_creator;
	}

}
