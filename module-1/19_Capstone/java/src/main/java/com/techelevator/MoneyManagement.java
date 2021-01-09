package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;
import com.techelevator.inventory.*;

public class MoneyManagement {

	private int currentBalance = 0;
	private int amountToFeed;

	public void addDollarsToBalance(int dollars) {

		currentBalance += dollars * 100; // current balance in cents
	}

	public String getFormattedBalanceInDollars() {
		
		//converts cents into dollars
		BigDecimal formattedBalance = BigDecimal.valueOf(currentBalance).movePointLeft(2);
		return "$" + formattedBalance;
	}

	public int getCurrentBalanceInCents() {
		return currentBalance;
	}

	public int getRemainingBalaceInCents(Item product) {
		
		//converts price into cents
		int price = product.getPrice().movePointRight(2).intValueExact();
		
		currentBalance -= price;
		return currentBalance;

	}
	

	public int feedMoney(Scanner input) {
	

		int amountToFeed = 0;

		do {
			System.out.println("Enter amount in whole dollars: $");
			try {
				amountToFeed = Integer.valueOf(input.nextLine());
				if (amountToFeed <= 0) {
					System.out.println("Must enter a positive number");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a valid whole number");
			}
		} while (amountToFeed <= 0);
		
		Logger logger = new Logger();
		logger.logFeed(currentBalance, amountToFeed);

		return amountToFeed;

	}
	
	public void getChange() {
		
		Logger logger = new Logger();
		logger.logChange(getCurrentBalanceInCents());
		
		int[] change = {currentBalance/25, (currentBalance%=25)/10, (currentBalance%=10)/5};
		System.out.println("\nChange: Quarters: " + change[0] + ". Dimes: " + change[1] + ". Nickels: " + change[2]);
		
		currentBalance = 0;
		System.out.println("Available Balance: " + getFormattedBalanceInDollars());
	
		
	}


}