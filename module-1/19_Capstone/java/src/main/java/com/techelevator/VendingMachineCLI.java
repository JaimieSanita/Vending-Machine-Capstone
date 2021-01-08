package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.*;

public class VendingMachineCLI {

	// CONSTANT VARIABLES
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS = "Finish Transactions";
	private static String currentMoney = " \nCurrent Money Provided: $";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS };

	private MoneyManagement balance = new MoneyManagement();

	// VARIABLES
	private Menu menu;
	private Menu purchaseMenu;
	private Scanner userInput = new Scanner(System.in);

	File inventoryFile = new File("vendingmachine.csv");
	// call a module that loads the pokedex
	CsvLoader loader = new CsvLoader(inventoryFile);
	Inventory inventory = loader.loadInventory();

	// CONSTRUCTOR
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	// HELPER METHOD

	public Item selectProduct() {

		Item result = null;
		String productSelection = null; //slotId
		do {
			System.out.println("Please a select a product >>>");
			try {
				productSelection = userInput.nextLine();
				Item i = inventory.getItemBySlot(productSelection);
				//inventory.getItemByName does not exist
				
				if(inventory.isItemSoldOut(productSelection)) {
					System.out.println("This item is sold out. Please select another item.");
				}
				
			}
				//inventory.getItem 
				//if/else	
			//	if (!freshInventoryList.contains(productSelection)) {
				//	System.out.println("That product does not exist. Please try again.");
					// loop to purchase menu
			//	}
			//	for (int i = 0; i < freshInventoryList.size(); i++) {
			//		if (freshInventoryList.get(i).equals(productSelection)
			//				&& freshInventoryList.get(i).getQuantity() == 0) {
			//			System.out.println("This product is sold out. Please try again.");
			//		}
//
			//	}
		//	} catch (NumberFormatException nfe) {
		//		System.out.println("Please do something else.");
		//	}
	//	} while (result == null);
	//	return result;
//	}

	public int feedMoney() {

		int amountToFeed = 0;

		do {
			System.out.println("Enter amount in whole dollars: $");
			try {
				amountToFeed = Integer.valueOf(userInput.nextLine());
				if (amountToFeed <= 0) {
					System.out.println("Must enter a positive number");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a valid whole number");
			}
		} while (amountToFeed <= 0);

		return amountToFeed;

	}

	// create a loop for purchase menu
	public void run() {

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					System.out.println("Current Money Provided: " + balance.getFormattedBalance());
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						int amountFed = feedMoney();
						balance.addDollarsToBalance(amountFed);

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						inventory.displayInventory();
						//Item selection = selectProduct();
						//inventory.getItemBySlot(selection);

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS)) {
						// finishTransaction();
						System.out.println("Finish Transaction.");

					}
				}
			}
		}
	}

	// ENTRY POINT MAIN
	public static void main(String[] args) {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}

}
