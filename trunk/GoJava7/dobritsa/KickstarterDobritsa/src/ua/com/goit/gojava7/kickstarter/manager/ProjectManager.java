package ua.com.goit.gojava7.kickstarter.manager;

import ua.com.goit.gojava7.kickstarter.Kickstarter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class ProjectManager {
	private String BORDER = "\n________________________________________________________";
	private int SHIFT_ONE = 1;
	private int FIRST = 0;
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleInspector consoleInspector = new ConsoleInspector();
	
	Project project;
	CategoryStorage categoryStorage;
	Kickstarter kickstarter;
	
	public ProjectManager(Project project) {
		this.project = project;
	}
	
	public void viewProject() {
		consolePrinter.print(BORDER);
		//consolePrinter.print("Current category: " + category.getName());
		//consolePrinter.print("Current project: #" + (projectNumber) + "\n");
		//Project project = new Project();
		//project = categoryStorage.get(categoryNumber - SHIFT_ONE).get(projectNumber - SHIFT_ONE);
		consolePrinter.printFull(project);
		consolePrinter.print("\nType 0 to choose another project");
		consoleInspector.getCorrectInt(FIRST, 0);
	}
}
