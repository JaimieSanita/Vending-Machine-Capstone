package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import com.techelevator.inventory.*;

public class Logger {

	// good to go
	public void logFeed(BigDecimal currentBalance, BigDecimal amountFed) {

		BigDecimal endingBalanceInDollars = currentBalance.add(amountFed);

		String logPrint = "FEED MONEY: $" + amountFed.setScale(2) + " " + "$" + endingBalanceInDollars;

		printToLogFile(logPrint);
	}
	// Current available first followed by remaining funds

	public void logPurchase(Item product, BigDecimal endingBalance) {

		String productName = product.getItemName();
		String slotId = product.getSlotId();
		BigDecimal price = product.getPrice();

		BigDecimal initialBalance = endingBalance.add(price);

		String logPrint = productName + " " + slotId + " " + "$" + initialBalance + " " + "$" + endingBalance;

		printToLogFile(logPrint);
	}

	public void logChange(BigDecimal currentBalance) {

		String logPrint = "GIVE CHANGE: " + "$" + currentBalance + " " + "$" + BigDecimal.ZERO.setScale(2);

		printToLogFile(logPrint);
	}

	private void printToLogFile(String logPrint) { // throws IOException {

	

		StringBuilder logEntry = new StringBuilder();
		logEntry.append(
				String.format("%-24s", new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a").format(new java.util.Date())));
		logEntry.append(String.format("%-30s", logPrint));

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

		try (FileOutputStream f = new FileOutputStream(logger, true); PrintWriter pw = new PrintWriter(f)) {

			

			pw.println(logEntry);
			pw.flush();

		} catch (IOException e) {
			System.out.println("\n***WARNING: LOG FILE HAS BEEN DELETED.  COULD NOT RECORD TRANSACTION.***\n");
		}

	}


}
