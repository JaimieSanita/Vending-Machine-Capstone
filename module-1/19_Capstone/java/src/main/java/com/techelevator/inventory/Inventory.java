package com.techelevator.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	List<Item> freshInventoryList = new ArrayList();
	// consider setting quantity constant to 5

	// inventory needs purchasePrice, itemName, slotNumber

	public boolean isItemSoldOut(String slotId) {
		
		for (Item item: this.freshInventoryList) {
			if(item.getSlotId().equalsIgnoreCase(slotId)) {
				if(item.getQuantity() == 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}

	public Item getItemBySlot(String slotId) {

		for (Item item : this.freshInventoryList) {
			if (item.getSlotId().equalsIgnoreCase(slotId)) {// if these match
				return item; // returning item
			}
		}
		return null; // how return as an Item because slotID is a string
	}

	public int getItemQuantity() {
		
		
		// consider math
		return 0;
	}

	public int getRemainingQuantity() {
		return 0;
	}

	public void displayInventory() {
		System.out.println("\n");
		for (Item availableItem : freshInventoryList) {
			System.out.println(availableItem + "\n");
		}
	}

	public Inventory(List<Item> items) {
		this.freshInventoryList = items;
	}
}
