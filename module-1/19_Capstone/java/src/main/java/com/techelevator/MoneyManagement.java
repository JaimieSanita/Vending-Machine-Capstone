package com.techelevator;

import java.util.Scanner;
import com.techelevator.inventory.*;



public class MoneyManagement {
	
	private int currentBalance = 0;
	
	


	
	public void addDollarsToBalance(int dollars) {
		
		currentBalance += dollars * 100; //current balance in cents
	}

	//Get change reduces balance to 0 %
	
	public String getChange() {
		
		return null;
		//return quarters nickels
	}
	
	public String getFormattedBalance() {
		//return the balance as dollars and cents
		return null;
	}
	
	public int getCurrentInCents() {
		return currentBalance;
	}
	
}