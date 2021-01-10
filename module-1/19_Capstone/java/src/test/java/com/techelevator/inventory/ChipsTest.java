package com.techelevator.inventory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class ChipsTest {
	
	
	@Test
	public void chip_sound_returns() {
		
		Chips chip = new Chips(null, null, null, null);
		
		String expectedSound = "Crunch Crunch, Yum!";
		
		String actualSound = chip.sound();
		
		Assert.assertEquals("The category provided should return Crunch Crunch, Yum!",
				expectedSound, 
				actualSound);
	}
	
	@Test
	public void chip_get_slot_id_works() {
		
		String expectedId = "c3";
		
		Chips chip = new Chips("", expectedId , null, "");
		
		
		
		String actualId = chip.getSlotId();
		
		Assert.assertEquals("Expected the constructor slot ID to be in the getter.",
				expectedId, 
				actualId);
	}
	
	@Test
	public void chip_get_name_works() {
		String expectedName = "cola";
		
		Chips chip = new Chips("", "", null, expectedName);
		
		String actualName = chip.getItemName();
		
		Assert.assertEquals("Expected the constructor itemName to be in the getter.",
				expectedName, 
				actualName);
	}
	
	@Test 
	public void chip_get_type_works() {
		String expectedType = "Chips";
		
		Chips chip = new Chips(expectedType, "", null, "");
		
		String actualType = chip.getType();
		
		Assert.assertEquals("Expected the constructor type to be in the getter.",
				expectedType,
				actualType);
	}
	
	@Test 
	public void chip_get_price_works() {
		
		BigDecimal expectedPrice = BigDecimal.ONE;
		
		Chips chip = new Chips("", "", expectedPrice, "");
		
		BigDecimal actualPrice = chip.getPrice();
		
		Assert.assertEquals("Expected the constructor price to be in the getter.",
				expectedPrice, 
				actualPrice);
		
		
	}

}
