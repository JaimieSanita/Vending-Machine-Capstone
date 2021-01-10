package com.techelevator.inventory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class CandyTest {
	
	@Test
	public void candy_sound_returns() {
		
		Candy candy = new Candy(null, null, null, null);
		
		String expectedSound = "Munch Munch, Yum!";
		
		String actualSound = candy.sound();
		
		Assert.assertEquals("The category provided should return Glug Glug, Yum!",
				expectedSound, 
				actualSound);
	}
	
	@Test
	public void candy_get_slot_id_works() {
		
		String expectedId = "c3";
		
		Candy candy = new Candy("", expectedId , null, "");
		
		
		
		String actualId = candy.getSlotId();
		
		Assert.assertEquals("Expected the constructor slot ID to be in the getter.",
				expectedId, 
				actualId);
	}
	
	@Test
	public void candy_get_name_works() {
		String expectedName = "cola";
		
		Candy candy = new Candy("", "", null, expectedName);
		
		String actualName = candy.getItemName();
		
		Assert.assertEquals("Expected the constructor itemName to be in the getter.",
				expectedName, 
				actualName);
	}
	
	@Test 
	public void candy_get_type_works() {
		String expectedType = "Beverages";
		
		Candy candy = new Candy(expectedType, "", null, "");
		
		String actualType = candy.getType();
		
		Assert.assertEquals("Expected the constructor type to be in the getter.",
				expectedType,
				actualType);
	}
	
	@Test 
	public void candy_get_price_works() {
		
		BigDecimal expectedPrice = BigDecimal.ONE;
		
		Candy candy = new Candy("", "", expectedPrice, "");
		
		BigDecimal actualPrice = candy.getPrice();
		
		Assert.assertEquals("Expected the constructor price to be in the getter.",
				expectedPrice, 
				actualPrice);
		
		
	}

}
