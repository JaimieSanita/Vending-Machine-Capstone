package com.techelevator.inventory;

public abstract class Item {

	//VARIABLES (these variables will be different than the variables derived from file)
	protected String category;
	protected String sound;
	
	//GETTERS; DO WE NEED ANY SETTERS? IF YES, WHY?
	
	public String getCategory() {
		return category;
	}

	public String getSound() {
		return sound;
	}
	
	
	//DO WE NEED AN ABSTRACT METHOD TO BE OVERRIDDEN IN CATEGORY SUBCLASSES
	
	//CONSTRUCTOR
	public Item(String category, String sound) {
		this.category = category;
		this.sound = sound;
	}

	
	

	

}
