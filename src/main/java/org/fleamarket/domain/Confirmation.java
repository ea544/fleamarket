package org.fleamarket.domain;

public class Confirmation {
	long id;
	String message;
	public Confirmation(long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public long getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
	
	
}
