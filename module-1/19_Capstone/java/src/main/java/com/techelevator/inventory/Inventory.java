package com.techelevator.inventory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.Logger;
import com.techelevator.MoneyManagement;

public class Inventory {

	List<Item> freshInventoryList = new ArrayList();

	public Inventory(List<Item> items) {
		this.freshInventoryList = items;
	}

	protected boolean isItemSoldOut(Item product) {
		return product.getQuantity() < 1;

	}

	public Item selectProduct(Scanner input) {

		Item result = null;
		String productSelection = null;
		System.out.println("Please select item by entering slot ID>>>");
		try {
			productSelection = input.nextLine();
			Item i = getItemBySlot(productSelection);

			if (i == null) {
				System.out.println("This item does not exist.");

			} else if (isItemSoldOut(i)) {
				System.out.println(i.getItemName() + " is sold out\n");

			} else {
				result = i;
			}
		} catch (NullPointerException nfe) {
			System.out.println("Please enter valid item.");
		}

		return result;
	}

	public Item getItemBySlot(String slotId) {

		for (Item item : this.freshInventoryList) {
			if (item.getSlotId().equalsIgnoreCase(slotId)) {
				return item;
			}
		}
		return null;
	}

	public void displayInventory() {
		System.out.println("\n");

		for (Item availableItem : freshInventoryList) {
			System.out.println(availableItem + "\n");

		}
	}
}
