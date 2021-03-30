package com.albo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sincronizaciones")
public class Sincroniza {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="date")
	String date;
	
	@Column(name="amount_characters")
	Integer amountCharacters;
	
	@Column(name="amount_comics")
	Integer amountComics;
	
	@Column(name="amount_creators")
	Integer amountCreators;
	
	public Sincroniza() {}
	
	public Sincroniza(Date date,Integer amountChara, Integer amountComics,Integer amountCreat){
		this.date = date.toString();
		this.amountCharacters = amountChara;
		this.amountComics = amountComics;
		this.amountCreators = amountCreat;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public Integer getTotal() {
		return this.amountCharacters + this.amountComics + this.amountCreators; 
	}
}