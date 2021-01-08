package com.techelevator.inventory;

import java.math.BigDecimal;

public class Beverages extends Item {
	
	

	public Beverages(String type, String slotID, BigDecimal price, String itemName) {
		super(type, slotID, price, itemName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sound() {
		return "Glug Glug, Yum!";
	}


}
