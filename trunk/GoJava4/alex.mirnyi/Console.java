package Kickstarter;

import java.io.*;
import java.util.*;

public class Console {
	private Kickstarter kickstarter;
	
	public Console(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}
	
	public int inputData(int size) {
		while (true) {
			int inputData = inputAccept();
			if ( inputData > size || inputData < 0) {
				print("You entered invalid number. please try again");
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
			print("You entered unacceptable character. " +
		                       "Make a choise and press enter");
			return inputAccept();
		}
	}
	
	public void showCategories() {
		QuotesContainer quotes = new QuotesContainer();
		print(quotes.getRandom());	
		print("Please enter the number of the category you want to choose:"
				+ " or press \"0\" to leave the programm");
		for (int index = 0; index < kickstarter.getCategories().size(); index++) {
			print(index+1 + ". " + kickstarter.getCategories().get(index));
		}
		int categoryChoice = inputData(kickstarter.getCategories().size());
		if ( categoryChoice == 0 ) {
			print("Bye");
		} else {
//			System.out.println("Bye");
			showProjects(categoryChoice);
		}
	}
	
	public void showProjects(int categoryChoice) {
		print("You have chosen category " + 
				kickstarter.getCategories().get(categoryChoice- 1));
		print("Please enter a number of project for more information" +
		                   " or press \"0\" to see project menu");
		List<Integer> inputCheck = new ArrayList<Integer>();
		for (int index = 0; index < kickstarter.getProjects().size(); index++) {
			if (categoryChoice == kickstarter.getProjects().get(index).getCategory().getId()) {
				inputCheck.add(index+1);
				print(kickstarter.getProjects().get(index)); 
			}
		}
		int projectChoice = inputData(kickstarter.getProjects().size());
		if (projectChoice == 0 ) {
			showCategories();	
		} else if (inputCheck.contains(projectChoice)) {
			this.oneProjectChoice(categoryChoice, projectChoice);
		} else { 
			print("Invalid input number!!! Try again");
			showProjects(categoryChoice);
		}
	}
	
	public void oneProjectChoice(int categoryChoice, int projectChoice) {
		for (int index = 0; index < kickstarter.getProjects().size(); index++) {
			if ( projectChoice == 0 ) {
				showProjects(categoryChoice);
			} else if (categoryChoice == kickstarter.getProjects().get(index).getCategory().getId() &&
					   projectChoice == kickstarter.getProjects().get(index).getProjectId()) {
				print("You have chosen ");
				print(kickstarter.getProjects().get(index).fullInfo());
				print("To go back to the list of projects press \"0\"");
				int goToProjectLIst = inputData(1);
				if (goToProjectLIst == 0) {
					showProjects(categoryChoice);
				} else {
					print("You entered wrong number!!!!!!");
					oneProjectChoice(categoryChoice, projectChoice);
				}
				
			}
		}
	}
	
	
//	public String toString() {
//		return quote;
//	}
	public void print(){
		System.out.println(string);
	}
	
//	public void print(Quotes string){
//		System.out.println(string);
//	}
}













//package Kickstarter;
//
//import java.io.*;
//import java.util.*;
//
//public class Console {
//	private Kickstarter kickstarter;
//	
//	public Console(Kickstarter kickstarter) {
//		this.kickstarter = kickstarter;
//	}
//	
//	public int inputData(int size) {
//		while (true) {
//			int inputData = inputAccept();
//			if ( inputData > size || inputData < 0) {
//				System.out.println("You entered invalid number. please try again");
//			} else {
//				return inputData;
//			}
//		}
//	}
//	
//	public int inputAccept() {
//		try {
//			Scanner in = new Scanner(System.in);
//			return in.nextInt();
//		} catch (InputMismatchException e) {
//			System.err.println("You entered unacceptable character. " +
//		                       "Make a choise and press enter");
//			return inputAccept();
//		}
//	}
//	
//	public void showCategories() {
//		QuotesContainer quotes = new QuotesContainer();
//		System.out.println(quotes.getRandom());	
//		System.out.println("Please enter the number of the category you want to choose:"
//				+ " or press \"0\" to leave the programm");
//		for (int index = 0; index < kickstarter.getCategories().size(); index++) {
//			System.out.println(index+1 + ". " + kickstarter.getCategories().get(index));
//		}
//		int categoryChoice = inputData(kickstarter.getCategories().size());
//		if ( categoryChoice == 0 ) {
//			System.out.println("Bye");
//		} else {
////			System.out.println("Bye");
//			showProjects(categoryChoice);
//		}
//	}
//	
//	public void showProjects(int categoryChoice) {
//		System.out.println("You have chosen category " + 
//				kickstarter.getCategories().get(categoryChoice- 1));
//		System.out.println("Please enter a number of project for more information" +
//		                   " or press \"0\" to see project menu");
//		List<Integer> inputCheck = new ArrayList<Integer>();
//		for (int index = 0; index < kickstarter.getProjects().size(); index++) {
//			if (categoryChoice == kickstarter.getProjects().get(index).getCategory().getId()) {
//				inputCheck.add(index+1);
//				System.out.println(kickstarter.getProjects().get(index)); 
//			}
//		}
//		int projectChoice = inputData(kickstarter.getProjects().size());
//		if (projectChoice == 0 ) {
//			showCategories();	
//		} else if (inputCheck.contains(projectChoice)) {
//			this.oneProjectChoice(categoryChoice, projectChoice);
//		} else { 
//			System.out.println("Invalid input number!!! Try again");
//			showProjects(categoryChoice);
//		}
//	}
//	
//	public void oneProjectChoice(int categoryChoice, int projectChoice) {
//		for (int index = 0; index < kickstarter.getProjects().size(); index++) {
//			if ( projectChoice == 0 ) {
//				showProjects(categoryChoice);
//			} else if (categoryChoice == kickstarter.getProjects().get(index).getCategory().getId() &&
//					   projectChoice == kickstarter.getProjects().get(index).getProjectId()) {
//				System.out.println("You have chosen ");
//				System.out.println(kickstarter.getProjects().get(index).fullInfo());
//				System.out.println("To go back to the list of projects press \"0\"");
//				int goToProjectLIst = inputData(1);
//				if (goToProjectLIst == 0) {
//					showProjects(categoryChoice);
//				} else {
//					System.out.println("You entered wrong number!!!!!!");
//					oneProjectChoice(categoryChoice, projectChoice);
//				}
//				
//			}
//		}
//	}
//	
//}



