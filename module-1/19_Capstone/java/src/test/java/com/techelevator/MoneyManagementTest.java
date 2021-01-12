package com.techelevator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import com.techelevator.inventory.Chips;
import com.techelevator.inventory.Item;

public class MoneyManagementTest {
	
	

	@Test
	public void get_formatted_balance_in_dollars_works() {
		MoneyManagement balance = new MoneyManagement();
		balance.addDollarsToBalance(5);
		String expectedFormattedBalance = "$5.00";
		String actualFormattedBalance = balance.getFormattedBalanceInDollars();
		
		Assert.assertEquals(expectedFormattedBalance, actualFormattedBalance);
		
	}
	
	@Test //tests addDollarsToBalance(int dollars) too
	public void get_current_balance_works() {
		MoneyManagement balance = new MoneyManagement();
		balance.addDollarsToBalance(1);
		int currentBalanceInCents = 100;
		int actualBalance = balance.getCurrentBalanceInCents();
		Assert.assertEquals(currentBalanceInCents, actualBalance);
	}
	
	
	@Test
	public void convert_cents_to_dollars_works() {
		MoneyManagement balance = new MoneyManagement();
		int amountInCents = 100;
		BigDecimal expectedReturn = BigDecimal.ONE.setScale(2);
		BigDecimal actualReturn = balance.convertCentsToDollars(amountInCents);
		
		Assert.assertEquals("Cents should be converted to dollars.",
				expectedReturn, 
				actualReturn);
		
	}
	
	@Test
	public void get_remaining_balance_in_cents_works() {
		MoneyManagement balance = new MoneyManagement();
		Item item = new Chips("a7", " ", BigDecimal.ONE, "chips");
		 balance.addDollarsToBalance(15);
		 int expectedRemainingBalanceInCents = 1400;
		 int actualRemainingBalance = balance.getRemainingBalanceInCents(item);
		
		Assert.assertEquals(
				expectedRemainingBalanceInCents, 
				actualRemainingBalance);
	}
	
	@Test //if balance is less than price, return balance
	public void get_remaining_balance_in_cents_works_negative_balance() {
		MoneyManagement balance = new MoneyManagement();
		Item item = new Chips("a7", " ", BigDecimal.TEN, "chips");
		 balance.addDollarsToBalance(5);
		 int expectedRemainingBalanceInCents = 500;
		 int actualRemainingBalance = balance.getRemainingBalanceInCents(item);
		
		Assert.assertEquals("If the remaining balance is less than item price, price is not subtracted.",
				expectedRemainingBalanceInCents, 
				actualRemainingBalance);
	}
	
	@Test
	public void feed_money_works() {
		MoneyManagement balance = new MoneyManagement();
		int expectedBalance = 5;
		int actualBalance = balance.feedMoney(new Scanner ("5\n"));
		Assert.assertEquals("Money fed into the vending machine should be stored.",
				expectedBalance, 
				actualBalance);
	}
	
	
	

}
