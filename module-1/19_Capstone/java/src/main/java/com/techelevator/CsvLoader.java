package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.techelevator.inventory.*;


public class CsvLoader {
	
private File inputFile;
	
	public CsvLoader(File inputFile) {
		this.inputFile = inputFile;
	}
	
	
	public Item convertLineIntoItem(String line) {
		
		String[] itemComponents = line.split("\\|");
		
		if(itemComponents.length != 4) {
			return null;
		}
		
		String slotId = itemComponents[0].trim();
		String itemName = itemComponents[1].trim();
		BigDecimal price = new BigDecimal(itemComponents[2].trim());
		String type = itemComponents[3].trim();
		
		if(type.toLowerCase().equals("drink")) {
			return new Beverages(slotId, itemName, price, type);
			
		} else if(type.toLowerCase().equals("chip")) {
			return new Chips(slotId, itemName, price, type);
		} else if (type.toLowerCase().equals("candy")){
			return new Candy(slotId, itemName, price, type);
		} else if (type.toLowerCase().equals("gum")){
			return new Gum(slotId, itemName, price, type);
		} else {
			return null;
		
		}
	}
	
	public Inventory loadInventory(){
		
		List<Item> inventoryList = new ArrayList();
		
		
		try(Scanner csvScanner = new Scanner(this.inputFile)){
			
			while(csvScanner.hasNextLine()) {
				String line = csvScanner.nextLine();
				Item newItem = convertLineIntoItem(line);
				
				if(newItem != null) {
					inventoryList.add(newItem);
				}
			}
			
		} catch (FileNotFoundException fnf) {
			return null;
			
		}
		return new Inventory(inventoryList);
	}


}
