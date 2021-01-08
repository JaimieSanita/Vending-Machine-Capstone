package com.techelevator.inventory;

import java.math.BigDecimal;

public class Gum extends Item {

	public Gum(String type, String slotID, BigDecimal price, String itemName) {
		super(type, slotID, price, itemName);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String sound() {
		return "Chew Chew, Yum!";
	}
}
