package ua.com.sas.view;


import ua.com.sas.model.Categories;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.model.Projects;
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
		 println(categories.getCategories() + "\nWhat are you interested in? Pleace, make your choice:");
	}
	
	public void showChosenCategory(Category category) {
		println("You chose - " + category.getName());
	}
	
	public void showProjects(Projects projects) {
		int j = 1;
		for (String project : projects.writeProjects()){
			println(j + ")" + project);
			j++;
		}
		println("If you want to return press \"0\"");
	}
	
	public void printChosenProject(Projects projects, Project project) {
		printHorizontalLine();
		println("You chose:"
				+ (projects.writeProject(project)));
		for (String s : projects.giveAllInfo(project)){
			println(s);
		}
		printHorizontalLine();
	}

	public void printHorizontalLine() {
		println("--------------------------------------------------");
	}
}
