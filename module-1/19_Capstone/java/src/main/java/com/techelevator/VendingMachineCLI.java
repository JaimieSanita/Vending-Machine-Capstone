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
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS };

	

	// VARIABLES
	private Menu menu;
	private Menu purchaseMenu;
	private Scanner userInput = new Scanner(System.in);

	private File inventoryFile = new File("vendingmachine.csv");
	private CsvLoader loader = new CsvLoader(inventoryFile);
	private Inventory inventory = loader.loadInventory();
	private MoneyManagement balance = new MoneyManagement();

	// CONSTRUCTOR
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	// create a loop for purchase menu
	public void run() {

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				while (true) {
					System.out.println("Available Balance: " + balance.getFormattedBalanceInDollars());
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						int amountFed = balance.feedMoney(userInput);
						balance.addDollarsToBalance(amountFed);

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

						inventory.displayInventory();
						Item productSelection = inventory.selectProduct(userInput);
						
						//If we get an Item from the method on line 69, the code below executes, if not it loops back to purchase menu
						while(productSelection != null) {
						inventory.dispenseItem(productSelection);
						balance.getRemainingBalaceInCents(productSelection);
						break; 
						}

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS)) {
						
						// finishTransaction();
						balance.getChange();
						break;


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
