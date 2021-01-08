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
		//return quarters nickels & dimes
	}
	
	public String getFormattedBalance() {
		
		return "$" + currentBalance/100;
	}
	
	public int getCurrentInCents() {
		return currentBalance;
	}
	
}