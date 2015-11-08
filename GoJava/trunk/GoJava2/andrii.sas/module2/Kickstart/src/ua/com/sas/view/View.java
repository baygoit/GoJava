package ua.com.sas.view;


import java.util.List;

import ua.com.sas.model.Categories;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.model.Quote;

public class View {
	
	Output output;
	
	public View(Output output) {
		this.output = output;
	}
	
	public void println(String message){
		output.println(message);
	}
	
	public void printQuote(Quote quote) {
		println(quote.generateQuote());
	}
	
	public void showList(Categories categories) {
		String categoriesList = "";
		int index = 1;
		for (Category category : categories.getCategories()){
			categoriesList += index + " - " + category.getName() + ((index == categories.size())? "" : ", ");
			index++;
		}
		println(categoriesList + "\nWhat are you interested in? Pleace, make your choice:");
	}
	
	public void showChosenCategory(Category category) {
		println("You chose - " + category.getName());
	}
	
	public void printChosenProject(Project project) {
		printHorizontalLine();
		println("You chose:"
				+ (writeProject(project)));
		giveAllInfo(project);
		printHorizontalLine();
	}
	
	public String writeProject(Project project) {
		return " Name - " + project.getName() + ", Description - "
				+ project.getDescription() + ", Money we need - "
				+ project.getMoneyNeed() + ", Money we have - "
				+ project.getMoneyHas() + ", Days left - "
				+ project.getDaysLeft();
	}
	
	public void showProjects(List<Project> projects) {
		int j = 1;
		for (Project project : projects) {
			println(j + ")" + writeProject(project));
			j++;
		}
		println("If you want to return press \"0\"");
	}
	
	public void giveAllInfo(Project project) {
		println(project.getHistory());
		println(project.getVideoLink());
		println(project.getQuestion());
	}

	public void printHorizontalLine() {
		println("--------------------------------------------------");
	}
	
	public void categoryChoiceError(){
		println("Error!! There are no such category - Try again:");
	}
	
	public void endMessage(){
		println("Thanks for using our program, Goodbye!");
	}
	
	public void projectChoiseError(){
		println("Error!! There are no such project - Try again:");
	}
	
}
