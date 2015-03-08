package ua.com.sas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import ua.com.sas.model.*;
import ua.com.sas.view.*;

public class Kickstart {
	private View view;
	private Input input;
	private Categories categories;
	private Projects projects;
	private Quote quote;
	private Category category;
	private int projectChoice;
	private Project project;
	 
	public Kickstart(View view, Input input, Categories categories, Projects projects, Quote quote) {
		this.view = view;
		this.input = input;
		this.categories = categories;
		this.projects = projects;
		this.quote = quote;
		
	}
	
	public void initSelectedCategory(int choice) {
		category = categories.get(choice);
	}

	public void receiveProjectsByCategory() {
		projects.getProjects(category);
	}

	public void initObjectOfSelectedProject(int projectChoice) {
		this.projectChoice = projectChoice;
		project = projects.get(projectChoice);
	}

	public void buildMenu(){
		view.printQuote(quote);
		Menu menu = new Menu(input, view) {
			
			@Override
			public void displayItems() {
				view.showList(categories);
			}
			
			@Override
			public void displayError() {
				view.categoryChoiceError();
			}

			@Override
			public void displaySelectedItems() {
				initSelectedCategory(getCheckedValue());
				view.showChosenCategory(category);
				receiveProjectsByCategory();
			}

			@Override
			public void toNextLevel() {
				goToProjectsMenu();
			}
		};
		menu.run(categories.size());
		view.endMessage();
	}
	
	public void goToProjectsMenu(){
		Menu menu = new Menu(input, view) {
			
			@Override
			public void displayItems() {
				view.showProjects(projects.getProjects(category));
			}
			
			@Override
			public void displayError() {
				view.projectChoiseError();
			}
			
			@Override
			public void displaySelectedItems() {
				initObjectOfSelectedProject(getCheckedValue());
				view.printChosenProject(project);
			}
			
			@Override
			public void toNextLevel() {
				goToProjecDetails();
			}
		};
		menu.run(projects.size());
	}

	public void goToProjecDetails(){
		Menu menu = new Menu(input, view) {
			
			@Override
			public void displayItems() {
				view.println("1 - invest to project, 2 - ask question (Return - 0)");
			}
			
			@Override
			public void displayError() {
				view.println("Error!! There are no such menu item, try again:");
			}
			
			@Override
			public void displaySelectedItems() {
				if (getCheckedValue() == 1){
					view.println("Thanks for choosing our project");
					int menuItem = 1;
					List<Integer> keys = new ArrayList<Integer>();
					for (Entry<Integer, String> entry : project.getPayments().entrySet()){
						keys.add(entry.getKey());
						view.println(menuItem + " - " + entry.getKey() + "$, Your bonus is - " + entry.getValue());
						menuItem++;
					}
					view.println(menuItem + " - your sum to invest");
					int payment = checkForEnteringLetters();
					String card;
						
					if (payment == menuItem){
						view.println("Please enter your name:");
						String name = input.readChoice();
						view.println("Please enter number of your credit card:");
						card = input.readChoice();
						view.println("Please enter the sum, which you want to invest:");
						int money = checkForEnteringLetters();
						view.println("Thank you " + name + " for investing " + money + "$ in our project!");
						project.increaseMoneyHas(money);
					} else if (payment > 0 && payment <= keys.size()) {
						project.increaseMoneyHas(keys.get(payment - 1));
					}
				} else if (getCheckedValue() == 2){
					view.println("Ask your question, please:");
					String question = input.readChoice();
					view.println("Your question is: " + question);
					project.addClientQuestion(question);
				}
				initObjectOfSelectedProject(projectChoice);
				view.printChosenProject(project);
			}
			
			@Override
			public void toNextLevel() {
				//TODO
			}
		};
		menu.run(2); //TODO delete magic number
	}
}
