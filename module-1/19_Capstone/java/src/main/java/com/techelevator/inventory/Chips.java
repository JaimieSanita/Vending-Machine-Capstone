package com.techelevator.inventory;

import java.math.BigDecimal;

public class Chips extends Item {

	public Chips(String type, String slotID, BigDecimal price, String itemName) {
		super(type, slotID, price, itemName);
		this.type = type;
		this.slotID = slotID;
		this.price = price;
		this.itemName = itemName;
	}
	
	@Override
	public String sound() {
		return "Crunch Crunch, Yum!";
	}



}
