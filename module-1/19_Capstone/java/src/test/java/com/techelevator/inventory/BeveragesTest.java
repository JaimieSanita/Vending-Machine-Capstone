package com.techelevator.inventory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class BeveragesTest {
	
	
	
	@Test
	public void beverage_sound_returns() {
		
		Beverages beverage = new Beverages(null, null, null, null);
		
		String expectedSound = "Glug Glug, Yum!";
		
		String actualSound = beverage.sound();
		
		Assert.assertEquals("The category provided should return Glug Glug, Yum!",
				expectedSound, 
				actualSound);
	}
	
	@Test
	public void beverage_get_slot_id_works() {
		
		String expectedId = "c3";
		
		Beverages beverage = new Beverages(expectedId,""  , null, "");
		
		
		
		String actualId = beverage.getSlotId();
		
		Assert.assertEquals("Expected the constructor slot ID to be in the getter.",
				expectedId, 
				actualId);
	}
	
	@Test
	public void beverage_get_name_works() {
		String expectedName = "cola";
		
		Beverages beverage = new Beverages("", expectedName, null, "");
		
		String actualName = beverage.getItemName();
		
		Assert.assertEquals("Expected the constructor itemName to be in the getter.",
				expectedName, 
				actualName);
	}
	
	@Test 
	public void beverage_get_type_works() {
		String expectedType = "Beverages";
		
		Beverages beverage = new Beverages("", "", null, expectedType);
		
		String actualType = beverage.getType();
		
		Assert.assertEquals("Expected the constructor type to be in the getter.",
				expectedType,
				actualType);
	}
	
	@Test 
	public void beverage_get_price_works() {
		
		BigDecimal expectedPrice = BigDecimal.ONE;
		
		Beverages beverage = new Beverages("", "", expectedPrice, "");
		
		BigDecimal actualPrice = beverage.getPrice();
		
		Assert.assertEquals("Expected the constructor price to be in the getter.",
				expectedPrice, 
				actualPrice);
		
		
	}
	

}
