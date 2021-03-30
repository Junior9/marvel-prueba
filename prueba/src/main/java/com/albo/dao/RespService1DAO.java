package com.albo.dao;

import java.util.ArrayList;
import java.util.List;

public class RespService1DAO {
	
	private String last_sync;
	private List<String> writer;
	private List<String> colorist;
	private List<String> penciller;
	private List<String> editor;
	
	public RespService1DAO(){
		this.writer = new ArrayList<>();
		this.colorist = new ArrayList<>();
		this.penciller = new ArrayList<>();
		this.editor = new ArrayList<>();
	}

	public String getLast_sync() {
		return last_sync;
	}


	public List<String> getWriter() {
		return writer;
	}


	public List<String> getColorist() {
		return colorist;
	}


	public List<String> getPenciller() {
		return penciller;
	}


	public List<String> getEditor() {
		return editor;
	}
	
	public void addWriter(String name) {
		this.writer.add(name);
	}
	
	public void addColorist(String name) {
		this.colorist.add(name);
	}
	
	public void addPenciller(String name) {
		this.penciller.add(name);
	}
	
	public void addEditor(String name) {
		this.editor.add(name);
	}
}