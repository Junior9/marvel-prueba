package com.albo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="characters_comics")
@ToString
@NoArgsConstructor
@Data
public class Character_Comics {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="marvel_characters_id")
	private Integer marvel_characters_id;
	
	@Column(name="marvel_comics_id")
	private Integer marvel_comics_id;
	
	
	public Character_Comics(Integer marvel_characters_id, Integer marvel_comics_id) {
		this.marvel_characters_id = marvel_characters_id;
		this.marvel_comics_id = marvel_comics_id;
	}
	
	public Integer getMarvelCharactersId() {
		return this.marvel_characters_id;
	}
	
}
