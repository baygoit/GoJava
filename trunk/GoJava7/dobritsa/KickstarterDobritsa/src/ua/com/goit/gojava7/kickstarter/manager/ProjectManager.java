package ua.com.goit.gojava7.kickstarter.manager;

import ua.com.goit.gojava7.kickstarter.Kickstarter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class ProjectManager {
	private String BORDER = "\n________________________________________________________";
	private int FIRST = 0;

	private ConsoleInspector consoleInspector = new ConsoleInspector();
	
	Project project;
	//CategoryStorage categoryStorage;
	Kickstarter kickstarter;
	
	public ProjectManager(Project project) {
		this.project = project;		
		//this.consoleInspector = consoleInspector;
	}
	
	public void viewProject(Integer selectedCategory, Integer selectedProject) {
		System.out.println(BORDER);
		//consolePrinter.print("Current category: " + category.getName());
		System.out.println("Current project: #" + (selectedProject) + "\n");		
		printFull(project);
		System.out.println("\nType 0 to choose another project");
		consoleInspector.getCorrectInt(FIRST, 0);
	}
	
	public void printShort(Project project) {
		System.out.println("Name: " + project.getName());
    	System.out.println("Short description: " + project.getDescription());
    	System.out.println("Goal: " + project.getGoal());
    	System.out.println("Pledged: " + project.getPledged());
    	System.out.println("Days to go: " + project.getDaysToGo());    	
	}
	
	public void printFull(Project project) {
		printShort(project);
		System.out.println("History: " + project.getHistory());
    	System.out.println("Link to the demo video: " + project.getLink());
    	System.out.println("Questions/Answers: " + project.getQuestions());
	}
}
