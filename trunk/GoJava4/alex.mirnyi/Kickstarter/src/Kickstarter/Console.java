package Kickstarter;

import java.io.*;
import java.util.*;

public class Console {
	private Kickstarter kickstarter;
	private Printer printer;
	
	public Console(Kickstarter kickstarter, Printer printer) {
		this.kickstarter = kickstarter;
		this.printer = printer;
	}
	
	public int inputData(int size) {
		while (true) {
			int inputData = inputAccept();
			if ( inputData > size || inputData < 0) {
				println("You entered invalid number. please try again");
			} else {
				return inputData;
			}
		}
	}
	
	public int inputAccept() {
		try {
			Scanner in = new Scanner(System.in);
			return in.nextInt();
		} catch (InputMismatchException e) {
			println("You entered unacceptable character. " +
		             "Make a choise and press enter");
			return inputAccept();
		}
	}
	
	public void showCategories() {
		QuotesContainer quotes = new QuotesContainer();
		println(quotes.getRandom().toString() +"\n");	
		println("Please enter the number of the category you want to choose" +
		        " or press \"0\" to leave the programm:\n");
		for (int index = 0; index < kickstarter.getCategories().size(); index++) {
			println((index+1) + ". " + kickstarter.getCategories().get(index));
		}
		println("---------------");
		int categoryChoice = inputData(kickstarter.getCategories().size());
		if ( categoryChoice == 0 ) {
			println("Bye");
		} else {
			showProjects(categoryChoice);
		}
	}
	
	public void showProjects(int categoryChoice) {
		println("Please enter a number of project for more information" +
                " or press \"0\" to see project menu:\n");
		println("You have chosen category " + 
				kickstarter.getCategories().get(categoryChoice- 1) + "\n");
		List<Integer> inputCheck = new ArrayList<Integer>();
		for (int index = 0; index < kickstarter.getProjects().size(); index++) {
			if (categoryChoice == kickstarter.getProjects().get(index).getCategory().getId()) {
				inputCheck.add(index+1);
				println(kickstarter.getProjects().get(index).toString()); 
			}
		}
		println("---------------");
		int projectChoice = inputData(kickstarter.getProjects().size());
		if (projectChoice == 0 ) {
			println("---------------");
			showCategories();	
		} else if (inputCheck.contains(projectChoice)) {
			this.oneProjectChoice(categoryChoice, projectChoice);
		} else { 
			println("Invalid input number!!! Try again");
			showProjects(categoryChoice);
		}
	}
	
	public void oneProjectChoice(int categoryChoice, int projectChoice) {
		for (int index = 0; index < kickstarter.getProjects().size(); index++) {
			if ( projectChoice == 0 ) {
				println("---------------");
				showProjects(categoryChoice);
			} else if (categoryChoice == kickstarter.getProjects().get(index).getCategory().getId() &&
					   projectChoice == kickstarter.getProjects().get(index).getProjectId()) {
				print("You have chosen ");
				println(kickstarter.getProjects().get(index).fullInfo());
				println("To go back to the list of projects press \"0\"");
				println("---------------");
				int goToProjectLIst = inputData(1);
				if (goToProjectLIst == 0) {
					showProjects(categoryChoice);
				} else {
					println("You entered wrong number!!!!!!");
					oneProjectChoice(categoryChoice, projectChoice);
				}
				
			}
		}
	}
	
	private void println(String string){
		print(string + "\n");
	}
	private void print(String string){
		printer.print(string);
	}
}

