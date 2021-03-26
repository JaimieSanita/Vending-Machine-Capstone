package com.techelevator.inventory;

import java.math.BigDecimal;

public abstract class Item {

	protected String type;
	protected String slotID;
	protected BigDecimal price;
	protected String itemName;
	protected int quantity;

	private static final int DEFAULT_QUANTITY = 5;

	public Item(String slotID, String itemName, BigDecimal price, String type) {
		this.type = type;
		this.slotID = slotID;
		this.price = price;
		this.itemName = itemName;
		this.quantity = DEFAULT_QUANTITY;
	}

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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {

		if (getQuantity() == 0) {
			return getSlotId() + " | " + getItemName() + " | " + "$" + getPrice() + " | " + getType() + " | " + "QTY: "
					+ "SOLD OUT";
		} else {
			return getSlotId() + " | " + getItemName() + " | " + "$" + getPrice() + " | " + getType() + " | " + "QTY: "
					+ getQuantity();
		}
	}

	public abstract String sound();

}
