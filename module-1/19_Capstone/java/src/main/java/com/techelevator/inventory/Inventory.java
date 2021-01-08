package com.techelevator.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	List<Item> freshInventoryList = new ArrayList();
	//consider setting quantity constant to 5
	
	//inventory needs purchasePrice, itemName, slotNumber
	
	public boolean isItemSoldOut(String slotId) {
		//loop through list to see if contains && quantity is not 0
		return true;
	}
	
	public int getItemQuantity() {
		//consider math
		return 0;
	}
	
	public int getRemainingQuantity() {
		return 0;
	}
								//display vending machine items(remainingQuantity, purchasePrice, itemName, slotNumber)
	public void displayInventory() {
		
	}
	
	

	public Inventory(List<Item> items) {
		this.freshInventoryList = items;
	}
}
