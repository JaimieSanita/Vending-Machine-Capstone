package com.techelevator.inventory;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String type, String slotID, BigDecimal price, String itemName) {
		super(type, slotID, price, itemName);
		this.type = type;
		this.slotID = slotID;
		this.price = price;
		this.itemName = itemName;
	}
	
	@Override
	public String sound() {
		return "Munch Munch, Yum!";
	}



}
