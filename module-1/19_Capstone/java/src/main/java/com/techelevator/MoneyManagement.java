package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;
import com.techelevator.inventory.*;

import com.techelevator.*;

public class MoneyManagement {

	private int currentBalanceInCents;
	

	public void addDollarsToBalance(int dollars) {

		currentBalanceInCents += (dollars * 100); // current balance in cents
	}

	public String getFormattedBalanceInDollars() {
		
		//converts cents into dollars
		BigDecimal formattedBalanceInDollars = convertCentsToDollars(currentBalanceInCents);
		
		return "$" + formattedBalanceInDollars;
	}

	public int getCurrentBalanceInCents() {
		return currentBalanceInCents;
	}
	
	public BigDecimal convertCentsToDollars(int amountInCents) {
		
		BigDecimal amountInDollars = BigDecimal.valueOf(amountInCents).movePointLeft(2);
		return amountInDollars;
	}
	
	public int getRemainingBalanceInCents(Item product) {
		
		
		//converts price into cents
		int price = product.getPrice().movePointRight(2).intValueExact();
		
		if(currentBalanceInCents - price >= 0) {
			
			currentBalanceInCents -= price;	
			Logger logger = new Logger();
			logger.logPurchase(product, convertCentsToDollars(currentBalanceInCents));
		}
		
		
		
		
		return currentBalanceInCents;
		

	}
	
	
public void dispenseItem(Item product) {
	
	int price = product.getPrice().movePointRight(2).intValueExact();
	
	if(currentBalanceInCents - price >= 0) {
	
		int newQuantity = product.getQuantity() - 1;
		product.setQuantity(newQuantity);

		// Displays Dispense Message
		System.out.println(
				"\nDispensing: " + product.getItemName() + ", $" + product.getPrice() + "\n" + product.sound() + "\n");
		}
		else {
			System.out.println("\nSorry you dont have enough money to buy " + product.getItemName() + 
					"\n" + "Please feed more money, and try again.\n");
		}
	}

	

	public int feedMoney(Scanner input) {
	

		int amountToFeedInDollars = 0;

		do {
			System.out.println("Enter amount in whole dollars: $");
			try {
				amountToFeedInDollars = Integer.valueOf(input.nextLine());
				if (amountToFeedInDollars <= 0) {
					System.out.println("Must enter a positive number");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a valid whole number");
			}
		} while (amountToFeedInDollars <= 0);
		
		Logger logger = new Logger();
		logger.logFeed(convertCentsToDollars(getCurrentBalanceInCents()), BigDecimal.valueOf(amountToFeedInDollars));

		return amountToFeedInDollars;

	}
	
	public void getChange() {
		
		Logger logger = new Logger();
		logger.logChange(convertCentsToDollars(getCurrentBalanceInCents()));
		
		int[] change = {currentBalanceInCents/25, (currentBalanceInCents%=25)/10, (currentBalanceInCents%=10)/5};
		System.out.println("\nChange: Quarters: " + change[0] + ". Dimes: " + change[1] + ". Nickels: " + change[2]);
		
		currentBalanceInCents -= currentBalanceInCents;
		System.out.println("Available Balance: " + getFormattedBalanceInDollars());
	
		
	}


}