package com.techelevator.inventory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class GumTest {
	
	
	@Test
	public void gum_sound_returns() {
		
		Gum gum = new Gum(null, null, null, null);
		
		String expectedSound = "Chew Chew, Yum!";
		
		String actualSound = gum.sound();
		
		Assert.assertEquals("The category provided should return Chew Chew, Yum!",
				expectedSound, 
				actualSound);
	}
	
	@Test
	public void gum_get_slot_id_works() {
		
		String expectedId = "c3";
		
		Gum gum = new Gum(expectedId, "" , null, "");
		
		
		
		String actualId = gum.getSlotId();
		
		Assert.assertEquals("Expected the constructor slot ID to be in the getter.",
				expectedId, 
				actualId);
	}
	
	@Test
	public void gum_get_name_works() {
		String expectedName = "cola";
		
		Gum gum = new Gum("", expectedName, null, "");
		
		String actualName = gum.getItemName();
		
		Assert.assertEquals("Expected the constructor itemName to be in the getter.",
				expectedName, 
				actualName);
	}
	
	@Test 
	public void gum_get_type_works() {
		String expectedType = "Gum";
		
		Gum gum = new Gum("", "", null, expectedType);
		
		String actualType = gum.getType();
		
		Assert.assertEquals("Expected the constructor type to be in the getter.",
				expectedType,
				actualType);
	}
	
	@Test 
	public void gum_get_price_works() {
		
		BigDecimal expectedPrice = BigDecimal.ONE;
		
		Gum gum = new Gum("", "", expectedPrice, "");
		
		BigDecimal actualPrice = gum.getPrice();
		
		Assert.assertEquals("Expected the constructor price to be in the getter.",
				expectedPrice, 
				actualPrice);
		
		
	}

}
