package ua.com.sas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ua.com.sas.model.Categories;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.model.Projects;
import ua.com.sas.model.Quote;
import ua.com.sas.view.Input;
import ua.com.sas.view.Output;

public class Kickstart {
	private Output output;
	private Input input;
	private Categories categories;
	private Projects projects;
	private Quote quote;
	private Category category;
	private int projectChoice;
	private Project project;
	 
	public Kickstart(Output output, Input input, Categories categories, Projects projects, Quote quote) {
		this.output = output;
		this.input = input;
		this.categories = categories;
		this.projects = projects;
		this.quote = quote;
		
	}
	
	public void println(String message){
		output.println(message);
	}
	
	public void printQuote() {
		println(quote.generateQuote());
	}

	public void showList() {
		 println(categories.getCategories() + "\nWhat are you interested in? Pleace, make your choice:");
	}

	public void showChoice(int choice) {
		category = categories.readCategory(choice);
		println("You chose - " + category.getName());
	}
	
	public void receiveProjectsByCategory() {
		projects.chooseProjects(category);
	}

	public void showProjects() {
		int j = 1;
		for (String project : projects.writeProjects()){
			println(j + ")" + project);
			j++;
		}
		println("If you want to return press \"0\"");
	}

	public void showChosenProject(int projectChoice) {
		this.projectChoice = projectChoice;
		project = projects.readObject(projectChoice);
		println("--------------------------------------------------");
		println("You chose:"
				+ (projects.writeProject(project)));
		for (String s : projects.giveAllInfo(project)){
			println(s);
		}
		println("--------------------------------------------------");
	}
	
	public void buildMenu(){
		printQuote();
		Menu menu = new Menu(input, output) {
			
			@Override
			public void displayItems() {
				showList();
			}
			
			@Override
			public void displayError() {
				println("Error!! There are no such category - Try again:");
			}

			@Override
			public void displaySelectedItems() {
				showChoice(getCheckedValue());
				receiveProjectsByCategory();
			}

			@Override
			public void toNextLevel() {
				goToProjectsMenu();
			}
		};
		menu.run(categories.getLenth());
		println("Thanks for using our program, Goodbye!");
	}
	
	public void goToProjectsMenu(){
		Menu menu = new Menu(input, output) {
			
			@Override
			public void displayItems() {
				showProjects();
			}
			
			@Override
			public void displayError() {
				println("Error!! There are no such project - Try again:");
			}
			
			@Override
			public void displaySelectedItems() {
				showChosenProject(getCheckedValue());
			}
			
			@Override
			public void toNextLevel() {
				goToProjecDetails();
			}
		};
		menu.run(projects.getLenth());
	}

	public void goToProjecDetails(){
		Menu menu = new Menu(input, output) {
			
			@Override
			public void displayItems() {
				println("1 - invest to project, 2 - ask question (Return - 0)");
			}
			
			@Override
			public void displayError() {
				println("Error!! There are no such menu item, try again:");
				
			}
			
			@Override
			public void displaySelectedItems() {
				if (getCheckedValue() == 0){
					println("Thanks for choosing our project");
					int menuItem = 1;
					List<Integer> keys = new ArrayList<>();
					for (Entry<Integer, String> entry : project.getPayments().entrySet()){
						keys.add(entry.getKey());
						println(menuItem + " - " + entry.getKey() + "$, Your bonus is - " + entry.getValue());
						menuItem++;
					}
					println(menuItem + " - your sum to invest");
					int payment = checkForEnteringLetters();
					String card;
						
					if (payment == menuItem){
						println("Please enter your name:");
						String name = input.readChoice();
						println("Please enter number of your credit card:");
						card = input.readChoice();
						println("Please enter the sum, which you want to invest:");
						int money = checkForEnteringLetters();
						println("Thank you " + name + " for investing " + money + "$ in our project!");
						project.increaseMoneyHas(money);
					} else if (payment > 0 && payment <= keys.size()) {
						project.increaseMoneyHas(keys.get(payment - 1));
					}
				} else if (getCheckedValue() == 1){
					println("Ask your question, please:");
					String question = input.readChoice();
					println("Your question is: " + question);
					project.addClientQuestion(question);
				}
				showChosenProject(projectChoice);
			}
			
			@Override
			public void toNextLevel() {
				//TODO
			}
		};
		menu.run(2); //TODO delete magic number
	}
}
