package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;
import com.techelevator.inventory.*;

public class MoneyManagement {

	private int currentBalance = 0;

	public void addDollarsToBalance(int dollars) {

		currentBalance += dollars * 100; // current balance in cents
	}

	// Get change reduces balance to 0 %

	public String getChange() {

		return null;
		// return quarters nickels & dimes
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
	
	// I moved feedMoney() here to keep all money methods together
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

		return amountToFeed;

	}

}