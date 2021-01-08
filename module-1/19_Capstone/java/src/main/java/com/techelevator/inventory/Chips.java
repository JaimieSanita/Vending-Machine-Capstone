package com.techelevator.inventory;

import java.math.BigDecimal;

public class Chips extends Item {

	public Chips(String type, String slotID, BigDecimal price, String itemName) {
		super(type, slotID, price, itemName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String sound() {
		return "Crunch Crunch, Yum!";
	}



}
