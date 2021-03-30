package com.albo.enuns;

public enum CreatorType {

	WRITERS("writers"), COLORISTS("colorists"),
	EDITOR("editor"), PENCIELLER("penciller"); 
	
	private String type;
	
	private CreatorType (String type){
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
