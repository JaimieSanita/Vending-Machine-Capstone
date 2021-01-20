package com.techelevator.inventory;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class ItemTest {
	
	@Test
	public void getSlotIdReturnsCorrectValue() {
		BigDecimal price = new BigDecimal(1.50);
		Item testItem = new Beverages( "D2", "Cola",price,"drink" );
		
		String expectedReturn = "D2";
		String actualReturn = testItem.getSlotId();
		
		Assert.assertEquals("Should return D2.",
				expectedReturn, 
				actualReturn);
		
	}

	@Test
	public void getPriceReturnsCorrectValue() {
		BigDecimal price = new BigDecimal(1.50);
		Item testItem = new Beverages( "D2", "Cola",price,"drink" );
		
		BigDecimal expectedReturn = new BigDecimal(1.50);
		BigDecimal actualReturn = testItem.getPrice();
		
		Assert.assertEquals("Should return 1.50.",
				expectedReturn, 
				actualReturn);
		
	}
	
	@Test
	public void getItemNameCorrectValue() {
		BigDecimal price = new BigDecimal(1.50);
		Item testItem = new Beverages( "D2", "Cola",price,"drink" );
		
		String expectedReturn = "Cola";
		String actualReturn = testItem.getItemName();
		
		Assert.assertEquals("Should return Cola",
				expectedReturn, 
				actualReturn);
		
	}
	
	@Test
	public void getQuantityCorrectValue() {
		BigDecimal price = new BigDecimal(1.50);
		Item testItem = new Beverages( "D2", "Cola",price,"drink" );
		
		int expectedReturn = 5;
		int actualReturn = testItem.getQuantity();
		
		Assert.assertEquals("Should return 5.",
				expectedReturn, 
				actualReturn);
		
	}
	
	@Test
	public void getTypeReturnsCorrectValue() {
		BigDecimal price = new BigDecimal(1.50);
		Item testItem = new Beverages( "D2", "Cola",price,"drink" );
		
		String expectedReturn = "drink";
		String actualReturn = testItem.getType();
		
		Assert.assertEquals("Should return drink",
				expectedReturn, 
				actualReturn);
		
	}
	
	@Test
	public void setQuantitySetsValue() {
		BigDecimal price = new BigDecimal(1.50);
		Item testItem = new Beverages( "D2", "Cola",price,"drink" );
		
		testItem.setQuantity(8);
		int expectedReturn = 8;
		int actualReturn = testItem.getQuantity();
		
		Assert.assertEquals("Should return 8.",
				expectedReturn, 
				actualReturn);
		
	}
	
	@Test
	public void itemToStringPrintsCorrectly() {
		BigDecimal price = new BigDecimal(1.50);
		price = price.setScale(2);
		Item testItem = new Beverages( "D2", "Cola",price,"drink" );
		
		String expectedReturn = "D2 | Cola | $1.50 | drink | QTY: 5";
		String actualReturn = testItem.toString();
		
		Assert.assertEquals("Item should print as: D2 | Cola | $1.50 | drink | QTY: 5",
				expectedReturn, 
				actualReturn);
		
	}
}
