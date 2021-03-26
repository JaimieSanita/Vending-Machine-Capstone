package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.*;

public class VendingMachineCLI {

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

	

	
	private Menu menu;
	private Menu purchaseMenu;
	private Scanner userInput = new Scanner(System.in);

	private File inventoryFile = new File("vendingmachine.csv");
	private CsvLoader loader = new CsvLoader(inventoryFile);
	private Inventory inventory = loader.loadInventory();
	private MoneyManagement balance = new MoneyManagement();


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	
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

						while(productSelection != null) {
						balance.dispenseItem(productSelection);
						balance.getRemainingBalanceInCents(productSelection);
						break; 
						}

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS)) {
						
		
						balance.getChange();
						break;


					}
				}
			}
			
			else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for shopping with us!. Come again soon.");
				System.exit(0);
			}
		}
	}


	public static void main(String[] args) {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
	


}
