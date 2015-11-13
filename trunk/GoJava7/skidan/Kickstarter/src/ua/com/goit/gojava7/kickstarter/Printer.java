package ua.com.goit.gojava7.kickstarter;

import java.util.List;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;



public class Printer {
	
	

	public static void print(String quote) {
		System.out.println(quote);

	}

	public static void prints(List<Category> list) {
		System.out.println("Categories");
		for (int i = 1; i < list.size(); i++) {
			System.out.println(i + "\t " + " > " + list.get(i).getTitle());

			// System.out.println(list.get(i).getProjectList().values());
		}
	}

	public static void exitInform() {
		System.out.println("\n" + "ENTER 0 FOR EXIT");

	}

	public static void CategoryInform() {
		System.out.println("\n" + " Choose category: ");

	}

	public static void ProjectInform() {
		System.out.println("\n" + "Choose project :");

	}

	public static void chosenCategoryInform(int categoryNumber) {
		try {
			String categoryName = CategoryStorage.getCategoriesByNumber(categoryNumber).getTitle();
			System.out.println("You have choosen " + categoryName + "\n");
		} catch (Exception e) {
			System.out.println("There is no such number of Category available");
			Kickstarter.category();
		}

	}

	public static void projectInform(int projectNumber, int categoryNumber) {
		Project p = CategoryStorage.getCategoriesByNumber(categoryNumber).getProjectList().get(projectNumber);
		System.out.println("Project Title : " + p.getTitle() + "\n" + "Project Discription :" + p.getDiscription()
				+ "\n" + "Project History : " + p.getProjectHistory() + "\n" + "Video Link : " + p.getVideoLink() + "\n"
				+ "Required Sum :" + p.getRequiredSum() + "\n" + "Gained Sum :" + p.getGainedSum() + "\n"
				+ "Days Left :" + p.getDaysLeft() + "\n");

	}

	public static void chosenProjectInform(int projectNumber, int categoryNumber) {
		try {
			String projectTitle = CategoryStorage.getCategoriesByNumber(categoryNumber).getProjectList()
					.get(projectNumber)
					.getTitle();
			System.out.println(" You have choosen : " + projectTitle + "\n");
		} catch (Exception e) {
			System.out.println("There is no such number of Project available");
			Kickstarter.project(categoryNumber);
		}

	}

	public static void categoryInform(int categoryNumber) {
		// System.out.println(CategoryStorage.getCategoriesByNumber(categoryNumber)
		// .getProjectList());
		Map<Integer, Project> listPojects = CategoryStorage.getCategoriesByNumber(categoryNumber).getProjectList();
		for (Project p : listPojects.values()) {
			System.out.println("Project Title : " + p.getTitle() + "\n" + "Project Discription :" + p.getDiscription()
					+ "\n" + "Required Sum :" + p.getRequiredSum() + "\n" + "Gained Sum :" + p.getGainedSum() + "\n"
					+ "Days Left :" + p.getDaysLeft() + "\n");

		}
		
		

	}
	public static void left(){
		System.out.println("You hava left the program");
	}
	
	public static void  toDoPosobilities(){
		System.out.println("You can donate to this project,"
				+ " if you want to please enter - 200, " +  "\n"
				+ "enter any number to go back to project select menu "+ "\n");
	}
	
	public static void payerNameGet(){
		System.out.println("Please enter cardholder name : ");
		
	}
	public static void payerCardIdGet(){
		System.out.println("Please enter cardId : ");
		
	}
	public static void  paymentOffer(){
		System.out.println("Enter amount of payment :");
	}
}