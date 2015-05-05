package oop;

import java.io.*;
import java.util.*;

public class Kickstarter {
	private Category category;
	private Project project;
	ArrayList<Category> categories;
	ArrayList<Project> projects;
	private static QuotesChoose quote;
	
	public Kickstarter() {
		categories = new ArrayList<Category>();
		projects = new ArrayList<Project>();
	}
	
	private static int inputData(int size) {
		while (true) {
			int inputData = inputAccept();
			if ( inputData > size || inputData < 0) {
				System.out.println("You entered invalid number. please try again");
			} else {
				return inputData;
			}
		}
	}
	
	private static int inputAccept() {
		try {
			Scanner in = new Scanner(System.in);
			return in.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("You entered unacceptable character. " +
		                       "Make a choise and press enter");
			return inputAccept();
		}
	}
	
	public void showCategories() {
		System.out.println("Please enter the number of the category you want to choose:"
				+ " or press \"0\" to leave the programm");
		for (int index = 0; index < this.categories.size(); index++) {
			System.out.println(index+1 + ". " + this.categories.get(index));
		}	
	}
	
	public void showProjects(int categoryChoice) {
		System.out.println("You have chosen category " + 
			    this.categories.get(categoryChoice- 1));
		System.out.println("Please enter a number of project for more information" +
		                   " or press \"0\" to see project menu");
		for (int index = 0; index < this.projects.size(); index++) {
			if (categoryChoice-1 == this.projects.get(index).getCategoryId()) {
				System.out.println(this.projects.get(index));
			}
		}
	}
	
	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		Category medicine = new Category("Medicine");
		Category music = new Category("Music");
		kickstarter.categories.add(medicine);
		kickstarter.categories.add(music);
		Project alcoTester = new Project(1, 0, "Alco Tester", 
				                         "Phenomenal alco test just by scanning your eyes",
    		                             50000, 23000, 15, "far away...",
    		                             "http://verbohlest.narod.ru", "some questions");
		kickstarter.projects.add(alcoTester);
		Project eyes = new Project(2, 0, "Eyes training device", "Get 100% sight",
    		      							 100000, 15000, 24, "far away...",
				                             "http://verbohlest.narod.ru", "some questions");
		kickstarter.projects.add(eyes);
		Project melody = new Project(3, 1, "Sing Melody", 
				                     "Sing melody and hear how it sounds in "
				                     + "different musical instruments",
				                     15000, 22000, 110, 
				                     "far away...", "http://verbohlest.narod.ru", 
				                     "some questions");
		kickstarter.projects.add(melody);
		
		System.out.println(quote.getRandom());
		
		while (true) {
			kickstarter.showCategories();
			
			int categoryChoice = inputData(kickstarter.categories.size());
			if ( categoryChoice == 0 ) {
				System.out.println("Bye");
				break;
			}
			kickstarter.showProjects(categoryChoice);
			
			int projectChoice = inputData(kickstarter.projects.size());
			for (int index = 0; index < kickstarter.projects.size(); index++) {
				if ( projectChoice == 0 ) {
					kickstarter.showCategories();
					int categoryChoice = inputData(kickstarter.categories.size());
					if ( categoryChoice == 0 ) {
						System.out.println("Bye");
						break;
					}
				} else if (categoryChoice-1 == kickstarter.projects.get(index).getCategoryId() &&
						projectChoice == kickstarter.projects.get(index).getProjectId()) {
					System.out.println("You have chosen ");
					System.out.println(kickstarter.projects.get(index).fullInfo());
					System.out.println("To go back to the list of projects press \"0\"");
					leaveProject = inputData(kickstarter.projects.size());
					if ( leaveProject == 0 ) {
						kickstarter.showProjects(leaveProject);
						if ( leaveProject == 0 ) {
							kickstarter.showCategories();
							if ( categoryChoice == 0 ) {
								System.out.println("Bye");
								break;
							}
						}
						break; 
					}
				}
			}
					
//			Scanner in = new Scanner(System.in);
//			int categoryChoice = inputAccept();
//			if ( categoryChoice == 0 ) {
//					break;
//				} else if ( categoryChoice > kickstarter.categories.size() || categoryChoice < 1) {
//					System.out.println("You entered invalid number. please try again");
//				} else {
//					System.out.println("You have chosen category " + 
//									   kickstarter.categories.get(categoryChoice- 1));
//					System.out.println("Please enter a number of project for more information");
//					for (int index = 0; index < kickstarter.projects.size(); index++) {
//						if ( categoryChoice == 0 ) {
//							break;
//						} else if (categoryChoice-1 == kickstarter.projects.get(index).getCategoryId()) {
//							System.out.println(kickstarter.projects.get(index));
//						}
//					}	
//					int projectChoice = inputAccept();
//					for (int index = 0; index < kickstarter.projects.size(); index++) {
//						if ( categoryChoice == 0 ) {
//							break;
//						} else if (categoryChoice-1 == kickstarter.projects.get(index).getCategoryId() &&
//								projectChoice == kickstarter.projects.get(index).getProjectId()) {
//							System.out.println(kickstarter.projects.get(index).fullInfo());
//						}
//					}	
//				}
		}
	}
}


//package oop;
//
//import java.io.*;
//import java.util.*;
//
//public class Kickstarter {
//	private static Category[] categories = new Category[]{
//        new Category("Medicine"),
//        new Category("Music")
//	};
//	private static Project[] medicine = new Project[]{
//        new Project(categories[0], "Alco Tester", "Phenomenal alco test just by scanning your eyes",
//        		    50000, 23000, 15, "far away...", "http://verbohlest.narod.ru", "some questions"),
//        new Project(categories[0], "Eyes training device", "Get 100% sight",
//        		    100000, 15000, 24, "far away...", "http://verbohlest.narod.ru", "some questions")
//	};
//	private static Project[] music = new Project[]{
//		new Project(categories[1], "Sing Melody", "Sing melody and hear how it sounds in "
//				+ "different musical instruments",
//				15000, 22000, 110, "far away...", "http://verbohlest.narod.ru", "some questions"),
//				new Project(categories[1], "Voice music player", "Listen music by the help of voice",
//						10000, 7000, 2, "far away...", "http://verbohlest.narod.ru", "some questions")
//	};
//	private static QuotesChoose quote;
//	
//	public Kickstarter() {
//	}
//	
//	private static int inputAccept() {
//		try {
//			Scanner in = new Scanner(System.in);
//			return in.nextInt();
//		} catch (InputMismatchException e) {
//			System.err.println("You entered unacceptable character. Make a choise and press enter");
//			return inputAccept();
//		}
//	}
//	public static void main(String[] args) {
//		System.out.println(quote.getRandom());
//		System.out.println("Please enter the number of the category you want to choose:\n");
//		for (int index = 0; index < categories.length; index++) {
//			System.out.println(index+1 + ". " + categories[index]);
//		}	
//		while (true) {
//			Scanner in = new Scanner(System.in);
//			int input = inputAccept();
//			if ( input == 0 ) {
//					break;
//				} else if ( input > categories.length || input < 1) {
//					System.out.println("You entered invalid number. please try again");
//				} else {
//					System.out.println("You have chosen category " + categories[input-1]);
//					System.out.println("Please enter a number of project for more information");
//					if ( input-1 == 0 ) {	
//						for (int index = 0; index < medicine.length; index++) {
//							System.out.println(index+1 + ". " + medicine[index]);
//						}
//					} else if (input-1 == 1 )
//						for (int index = 0; index < music.length; index++) {
//							System.out.println(index+1 + ". " + music[index]);
//						}
//					input = inputAccept();
//					if ( input == 0 ) {
//							break;
//						} else if ( input > music.length || 
//							 input < 1
//						   ) {
//							System.out.println("You entered invalid number. please try again");
//						} else {
//							System.out.println(music[input-1].fullInfo());
//							break;
//						}
//				}
//		}
//	}
//}