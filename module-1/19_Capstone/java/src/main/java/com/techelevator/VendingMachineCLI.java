package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.*;



public class VendingMachineCLI {

	//CONSTANT VARIABLES
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS = "Finish Transactions";
	private static String currentMoney = " \nCurrent Money Provided: $";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,  PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS};
	
	private MoneyManagement balance = new MoneyManagement();
	
	//VARIABLES
	private Menu menu;
	private Menu purchaseMenu;
	private Scanner userInput = new Scanner(System.in);
	
	File inventoryFile = new File("vendingmachine.csv");
	// call a module that loads the pokedex
	CsvLoader loader = new CsvLoader(inventoryFile);
	List<Item> freshInventoryList = loader.loadInventory();

	//CONSTRUCTOR
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	//HELPER METHOD
	
	public int feedMoney() {
		
		int amountToFeed = 0;
		
		do {
		System.out.println("Enter amount in whole dollars: $");
		try {
			amountToFeed = Integer.valueOf(userInput.nextLine());
			if(amountToFeed <=0) {
				System.out.println("Must enter a positive number");
			}
		} 
		catch(NumberFormatException nfe) {
			System.out.println("Please enter a valid whole number");
		}
		} while(amountToFeed <= 0);
		
		return amountToFeed;
		
	}
	
	//create a loop for purchase menu	
	public void run() {

		while (true) {
			
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				
				System.out.println("\n");
				for(Item availableItem : freshInventoryList) {
					System.out.println(availableItem + "\n");
					
				}
				
				// display vending machine items
				
				//create file
				
				//open file
				
				//read file
				
				//split each line into separate strings
					//String slotNumber
					//String itemName
					//Double purchasePrice
					//String itemCategory
				
				//if/else: product sold out
				
				
				//return item name & quantity(quantity will not be derived from file)
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("Current Money Provided: " + balance.getFormattedBalance());
				String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
					
					int amountFed = feedMoney();
					balance.addDollarsToBalance(amountFed);
				
				
					
				} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
					//selectProduct();
					System.out.println("Select Product.");
				} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS)){
					//finishTransaction();
					System.out.println("Finish Transaction.");
					
				}
				// do purchase
				
				//create sub purchase menu // main menu created via Andrew
				
				//feed money() within Money class; purpose to confirm whole #'s & update balance
					//related to current money provided variable
				
				//select products DOOZY
					//create new list from file OR use variables from above
				
					//display the items
						//String slotNumber
						//String itemName
						//Double purchasePrice
				
					//userSelection
				
					//if/else(String userSelection)
						//not exist, print message & loop to main menu
						//sold out, print message & loop to main menu
						
						//dispense 
							//create dispense method to pass through here(put in inventory)
				
				//finish transaction
				
				//current money provided
			}
		}
	}
	
	
	
	//ENTRY POINT MAIN
	public static void main(String[] args) {
		
		
		
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		
		
	}
	
	
}
