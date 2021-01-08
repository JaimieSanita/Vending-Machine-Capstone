package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.inventory.*;
import com.techelevator.*;
import com.techelevator.view.*;


import java.io.File;

public class Menu {

	//VARIABLES
	private PrintWriter out;
	private Scanner in;

	//CONSTRUCTOR
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output); //instantiating PrintWriter
		this.in = new Scanner(input);		//instantiating Scanner
	}

	//METHODS
		//METHOD for showing choice through display options
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options); //displays menu options to user
			choice = getChoiceFromUserInput(options); //allows user to select a choice from displayed menu
		}
		return choice; //choice is set to userInput of choice
	}
		//METHOD for getting user input for choice
	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}
	//MAIN MENU
	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			
			
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
			
		}
		
		
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	



		
	
	}
