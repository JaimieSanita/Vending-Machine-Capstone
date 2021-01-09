package com.techelevator;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import com.techelevator.inventory.*;
public class Logger {

	
	//method for feed money
	
	// FEED MONEY: AMOUNTFED NEWBALANCE
	
	public void logFeed(int currentBalance, int amountFed) {
		
		int newBalanceInCents = currentBalance + amountFed;
		
		//Converts cents to Dollars
		BigDecimal newBalanceInDollars = BigDecimal.valueOf(newBalanceInCents).movePointLeft(2);
		BigDecimal amountFedInDollars = BigDecimal.valueOf(amountFed).movePointLeft(2);
		
		String logPrint = "FEED MONEY: " + amountFedInDollars + newBalanceInDollars;
		
		printToLogFile(logPrint);
	}
	
	public void logPurchase(Item product, int initialBalance) {
		
		String productName = product.getItemName();
		String slotId = product.getSlotId();
		
		BigDecimal price = product.getPrice();
		BigDecimal endingBalance = BigDecimal.valueOf(initialBalance).subtract(price);
		
		String logPrint = productName + " " + slotId + " " +  "$" + BigDecimal.valueOf(initialBalance) + " " 
				+ "$" + endingBalance;
		
		
		printToLogFile(logPrint);
	}
	
	public void logChange(int currentBalance) {
		
		String logPrint = "GIVE CHANGE: " + "$" + currentBalance + " " + "$" + BigDecimal.ZERO;
		
		printToLogFile(logPrint);
	}
	
	
	private void printToLogFile(String logPrint) { //throws IOException {

		// Prepare line of output

		StringBuilder logEntry = new StringBuilder();			
		logEntry.append(String.format("%-24s", new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a").format(new java.util.Date())));
		logEntry.append(String.format("%-30s", logPrint));
		
		//logEntry.append(String.format("%1$8s","$"+start.toString()));
		//logEntry.append(String.format("%1$8s","$"+finish.toString()));

		// Define log file

		File logger = new File("Log.txt");

		// If log file does not exist, create it

		if (!logger.exists()) {
			
			try {
				logger.createNewFile();
			} catch (IOException e) {
				System.out.println("\n*** WARNING: UNABLE TO CREATE LOG FILE***\n");
			}
			
			
		} else if (logger.exists() && logger.isDirectory()) {
			System.out.println("\n***WARNING: DIRECTORY WITH NAME \"Log.txt\" exists.***\n");
		}


		try (FileOutputStream f = new FileOutputStream(logger,true); 
			PrintWriter pw = new PrintWriter(f)) {

			// make the log entry

			pw.println(logEntry);
			pw.flush();

		} catch (IOException e) {
			System.out.println("\n***WARNING: LOG FILE HAS BEEN DELETED.  COULD NOT RECORD TRANSACTION.***\n");
		}

	}
		
	//ITEM NAME SLOT ID CURRENT BALANCE ENDING BALANCE
	
	//method for dispensing change
	//GIVE CHANGE: CURRENT BALANCE $O
}
