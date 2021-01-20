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


import com.techelevator.*;

public class InventoryTest {
	



@Test
public void returnsCorrectSoldOutStatus() {
	List<Item> itemslist = new ArrayList();
	Inventory inventoryTest = new Inventory(itemslist);
	BigDecimal price = new BigDecimal(1.50);
	Item testItem = new Chips("A1","Bag Of Chips",price, "chip");
	itemslist.add(testItem);
	
	boolean expectedReturn = false;
	boolean actualReturn = inventoryTest.isItemSoldOut(testItem);
	
	Assert.assertEquals("Should return false", expectedReturn, actualReturn);
	
}

@Test
public void selectsCorrectItemBySlotId() {
	List<Item> itemslist = new ArrayList();
	Inventory inventoryTest = new Inventory(itemslist);
	BigDecimal price = new BigDecimal(1.50);
	Item testItem = new Chips("A1","Bag Of Chips",price, "chip");
	itemslist.add(testItem);
	
	Item expectedReturn = testItem;
	Item actualReturn = inventoryTest.getItemBySlot("A1");
	
	Assert.assertEquals("Should return test item", expectedReturn, actualReturn);
	
}

@Test
public void selectsCorrectItemByUserInput() {
	List<Item> itemslist = new ArrayList();
	Inventory inventoryTest = new Inventory(itemslist);
	BigDecimal price = new BigDecimal(1.50);
	Item testItem = new Chips("A1","Bag Of Chips",price, "chip");
	itemslist.add(testItem);
	
	Item expectedReturn = testItem;
	Item actualReturn = inventoryTest.selectProduct(new Scanner ("A1\n"));
	
	Assert.assertEquals("Should return test item", expectedReturn, actualReturn);
	
}



		
		
		


}
