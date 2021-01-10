package com.techelevator.inventory;

import java.math.BigDecimal;

public class Gum extends Item {

	public Gum(String type, String slotID, BigDecimal price, String itemName) {
		super(type, slotID, price, itemName);
		this.type = type;
		this.slotID = slotID;
		this.price = price;
		this.itemName = itemName;
	}

	
	@Override
	public String sound() {
		return "Chew Chew, Yum!";
	}
}
