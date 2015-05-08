package Kickstarter;

import java.io.*;
import java.util.*;

public class Kickstarter {
	private CategoriesContainer categories;
	private ProjectsContainer projects;
	
	public Kickstarter() {
		categories = new CategoriesContainer();
		projects = new ProjectsContainer();
	}
	
	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		
		Category medicine = new Category("Medicine");
		Category music = new Category("Music");

		kickstarter.getCategories().add(medicine);
		kickstarter.getCategories().add(music);
		
		Project alcoTester = new Project(medicine, "Alco Tester", 
				                         "Phenomenal alco test just by scanning your eyes",
    		                             50000, 23000, 15, "my history1", "www.verbohlest.narod.ru", "my question1");
		kickstarter.getProjects().add(alcoTester);
		
		Project eyes = new Project(medicine, "Eyes training device", "Get 100% sight",
    		      							 100000, 15000, 24);
		kickstarter.getProjects().add(eyes);
		
		Project melody = new Project(music, "Sing Melody", 
				                     "Sing melody and hear how it sounds in "
				                     + "different musical instruments",
				                     15000, 22000, 110);
		kickstarter.getProjects().add(melody);
						
		Console console = new Console(kickstarter);
		
		console.showCategories();
	}

	public CategoriesContainer getCategories() {
		return categories;
	}

	public void setCategories(CategoriesContainer categories) {
		this.categories = categories;
	}

	public ProjectsContainer getProjects() {
		return projects;
	}

	public void setProjects(ProjectsContainer projects) {
		this.projects = projects;
	}
}






//package Kickstarter;
//
//import java.io.*;
//import java.util.*;
//
//public class Kickstarter {
//	private List<Category> categories;
//	private List<Project> projects;
//	
//	public Kickstarter() {
//		categories = new ArrayList<Category>();
//		projects = new ArrayList<Project>();
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
//		Quotes quotes = new Quotes();
//		System.out.println(quotes.getRandom());	
//		System.out.println("Please enter the number of the category you want to choose:"
//				+ " or press \"0\" to leave the programm");
//		for (int index = 0; index < this.categories.size(); index++) {
//			System.out.println(index+1 + ". " + this.categories.get(index));
//		}
//		int categoryChoice = inputData(this.categories.size());
//		if ( categoryChoice == 0 ) {
//			System.out.println("Bye");
//		} else {
//			this.showProjects(categoryChoice);
//		}
//	}
//	
//	public void showProjects(int categoryChoice) {
//		System.out.println("You have chosen category " + 
//			    this.categories.get(categoryChoice- 1));
//		System.out.println("Please enter a number of project for more information" +
//		                   " or press \"0\" to see project menu");
//		List<Integer> inputCheck = new ArrayList<Integer>();
//		for (int index = 0; index < this.projects.size(); index++) {
//			if (categoryChoice-1 == this.projects.get(index).getCategory().getId()) {
//				inputCheck.add(index+1);
//				System.out.println(this.projects.get(index)); 
//			}
//		}
//		int projectChoice = inputData(this.projects.size());
//		if (projectChoice == 0 ) {
//			this.showCategories();	
//		} else if (inputCheck.contains(projectChoice)) {
//			oneProjectChoice(categoryChoice, projectChoice);
//		} else { 
//			System.out.println("Invalid input number!!! Try again");
//			showProjects(categoryChoice);
//		}
//	}
//	
//	public void oneProjectChoice(int categoryChoice, int projectChoice) {
//		for (int index = 0; index < this.projects.size(); index++) {
//			if ( projectChoice == 0 ) {
//				this.showProjects(categoryChoice);
//			} else if (categoryChoice-1 == this.projects.get(index).getCategory().getId() &&
//					   projectChoice == this.projects.get(index).getProjectId()) {
//				System.out.println("You have chosen ");
//				System.out.println(this.projects.get(index).fullInfo());
//				System.out.println("To go back to the list of projects press \"0\"");
//				int goToProjectLIst = inputData(1);
//				if (goToProjectLIst == 0) {
//					this.showProjects(categoryChoice);
//				} else {
//					System.out.println("You entered wrong number!!!!!!");
//					oneProjectChoice(categoryChoice, projectChoice);
//				}
//				
//			}
//		}
//	}
//
//	
//	public static void main(String[] args) {
//		Kickstarter kickstarter = new Kickstarter();
//		
//		Category medicine = new Category(0, "Medicine");
//		Category music = new Category(1, "Music");
//		kickstarter.categories.add(medicine);
//		kickstarter.categories.add(music);
//		
//		Project alcoTester = new Project(1, medicine, "Alco Tester", 
//				                         "Phenomenal alco test just by scanning your eyes",
//    		                             50000, 23000, 15, "far away...",
//    		                             "http://verbohlest.narod.ru", "some questions");
//		kickstarter.projects.add(alcoTester);
//		Project eyes = new Project(2, medicine, "Eyes training device", "Get 100% sight",
//    		      							 100000, 15000, 24, "far away...",
//				                             "http://verbohlest.narod.ru", "some questions");
//		kickstarter.projects.add(eyes);
//		Project melody = new Project(3, music, "Sing Melody", 
//				                     "Sing melody and hear how it sounds in "
//				                     + "different musical instruments",
//				                     15000, 22000, 110, 
//				                     "far away...", "http://verbohlest.narod.ru", 
//				                     "some questions");
//		kickstarter.projects.add(melody);
//						
//		kickstarter.showCategories();
//		
//	}
//
//}