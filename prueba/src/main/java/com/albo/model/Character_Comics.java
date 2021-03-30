package com.albo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="characters_comics")
public class Character_Comics {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="marvel_characters_id")
	private Integer marvel_characters_id;
	
	@Column(name="marvel_comics_id")
	private Integer marvel_comics_id;
	
	public Character_Comics() {}
	
	public Character_Comics(Integer marvel_characters_id, Integer marvel_comics_id) {
		this.marvel_characters_id = marvel_characters_id;
		this.marvel_comics_id = marvel_comics_id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Integer getMarvelComicsId() {
		return this.marvel_comics_id;
	}

	public Integer getMarvelCharactersId() {
		return this.marvel_characters_id;
	}
	
	/*
	 * 
	id INT AUTO_INCREMENT  PRIMARY KEY,
    marvel_characters_id INT NOT NULL,
    marvel_comics_id INT NOT NULL,
    FOREIGN KEY (marvel_characters_id) REFERENCES characters(marvel_Id),
    FOREIGN KEY (marvel_comics_id) REFERENCES comics(marvel_Id)
	 */
}
