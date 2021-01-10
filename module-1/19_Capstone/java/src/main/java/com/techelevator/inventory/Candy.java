package com.techelevator.inventory;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String slotID, String itemName, BigDecimal price, String type) {
		super(slotID, itemName,  price, type);
		this.slotID = slotID;
		this.itemName = itemName;
		this.price = price;
		this.type = type;
	}
	
	@Override
	public String sound() {
		return "Munch Munch, Yum!";
	}



}
