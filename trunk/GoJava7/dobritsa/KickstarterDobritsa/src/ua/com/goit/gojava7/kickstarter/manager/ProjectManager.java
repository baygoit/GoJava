package ua.com.goit.gojava7.kickstarter.manager;

import ua.com.goit.gojava7.kickstarter.Kickstarter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class ProjectManager {
	private String BORDER = "\n________________________________________________________";
	private int FIRST = 0;
	private ConsolePrinter consolePrinter;
	private ConsoleInspector consoleInspector;
	
	Project project;
	CategoryStorage categoryStorage;
	Kickstarter kickstarter;
	
	public ProjectManager(Project project, ConsolePrinter consolePrinter, ConsoleInspector consoleInspector) {
		this.project = project;
		this.consolePrinter = consolePrinter;
		this.consoleInspector = consoleInspector;
	}
	
	public void viewProject(Integer selectedCategory, Integer selectedProject) {
		consolePrinter.print(BORDER);
		//consolePrinter.print("Current category: " + category.getName());
		consolePrinter.print("Current project: #" + (selectedProject) + "\n");		
		consolePrinter.printFull(project);
		consolePrinter.print("\nType 0 to choose another project");
		consoleInspector.getCorrectInt(FIRST, 0);
	}
}
