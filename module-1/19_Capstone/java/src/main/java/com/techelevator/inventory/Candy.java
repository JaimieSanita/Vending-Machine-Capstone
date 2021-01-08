package com.techelevator.inventory;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String type, String slotID, BigDecimal price, String itemName) {
		super(type, slotID, price, itemName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String sound() {
		return "Munch Munch, Yum!";
	}



}
