package com.techelevator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.inventory.Item;

public class CsvLoaderTest {
	
	@Test
	public void convert_line_to_item_get_chip() {
	
		CsvLoader loader = new CsvLoader(null);
		
		String testLine = "A1|Potato Crisps|3.05|Chip";
		Item chip = loader.convertLineIntoItem(testLine);
		String expectedChipSlotId = "A1";
		String actualChipSlotId = chip.getSlotId();
		
		Assert.assertEquals("Chip item should be created from CSV file line.",
				expectedChipSlotId, 
				actualChipSlotId);
	}
	
	@Test
	public void convert_line_to_item_get_gum() {
	
		CsvLoader loader = new CsvLoader(null);
		
		String testLine = "D2|Little League Chew|0.95|Gum";
		Item gum = loader.convertLineIntoItem(testLine);
		String expectedName = "Little League Chew";
		String actualName = gum.getItemName();
		
		Assert.assertEquals("Gum item should be created from CSV file line.",
				expectedName, 
				actualName);
	}
	
	@Test
	public void convert_line_to_item_get_drink() {
	
		CsvLoader loader = new CsvLoader(null);
		
		String testLine = "C2|Dr. Salt|1.50|Drink";
		Item drink = loader.convertLineIntoItem(testLine);
		String expectedType = "Drink";
		String actualType = drink.getType();
		
		Assert.assertEquals("Drink item should be created from CSV file line.",
				expectedType, 
				actualType);
	}
	
	@Test
	public void convert_line_to_item_get_candy() {
	
		CsvLoader loader = new CsvLoader(null);
		
		String testLine = "B1|Moonpie|1.80|Candy";
		Item candy = loader.convertLineIntoItem(testLine);
		BigDecimal expectedPrice = BigDecimal.valueOf(1.80).setScale(2);
		BigDecimal actualPrice = candy.getPrice();
		
		Assert.assertEquals("Candy item should be created from CSV file line.",
				expectedPrice, 
				actualPrice);
	}
	
	

}
