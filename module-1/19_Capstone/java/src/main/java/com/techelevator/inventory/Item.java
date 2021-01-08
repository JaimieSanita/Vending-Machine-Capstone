package com.techelevator.inventory;

import java.math.BigDecimal;

public abstract class Item {

	//VARIABLES (these variables will be different than the variables derived from file)
	
	private String type;
	private String slotID;
	private BigDecimal price;
	private String itemName;
	private int quantity;

	
	private static final int DEFAULT_QUANTITY = 5;
	
	
	//DO WE NEED AN ABSTRACT METHOD TO BE OVERRIDDEN IN CATEGORY SUBCLASSES
	
	//CONSTRUCTOR
	public Item(String slotID,String itemName,BigDecimal price, String type ) {
		this.type = type;
		this.slotID = slotID;
		this.price = price;
		this.itemName = itemName;
		this.quantity = DEFAULT_QUANTITY;
	}
	
	
	//GETTERS

	public String getSlotId() {
		return slotID;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		
		if(getQuantity() == 0) {
			return getSlotId() + " | " + getItemName() + " | " + "$" + getPrice() + " | " + getType() + " | " + "QTY: " + "SOLD OUT";
		}
		else {
		return getSlotId() + " | " + getItemName() + " | " + "$" + getPrice() + " | " + getType() + " | " + "QTY: " + getQuantity();}
	}
	
	
	public abstract String sound();
		

	
	

	

}
