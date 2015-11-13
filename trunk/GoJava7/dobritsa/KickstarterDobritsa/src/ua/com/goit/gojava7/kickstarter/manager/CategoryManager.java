package ua.com.goit.gojava7.kickstarter.manager;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class CategoryManager {	
	private ConsoleInspector consoleInspector = new ConsoleInspector();
	private CategoryStorage categoryStorage;
	private Category category;
	private ProjectManager projectManager;
	
	private String BORDER = "\n________________________________________________________";
	private int SHIFT_ONE = 1;
	private int FIRST = 1;
	//private Integer selectedProject = -1;
	//private Integer selectedCategory = -1;

	public CategoryManager(CategoryStorage categoryStorage, Category category, ProjectManager projectManager) {		
		this.categoryStorage = categoryStorage;
		this.category = category;
		this.projectManager = projectManager;
	}

	public Integer chooseCategory() {	
		System.out.println(BORDER);
		System.out.println("\nList of categories:");
		printCategories(categoryStorage.getAll());
		System.out.println("\nChoose a category by number (0 for exit): ");
		Integer selectedCategory = consoleInspector.getCorrectInt(FIRST, categoryStorage.size());
		if (selectedCategory == null) {
			consoleInspector.close();
			System.out.println("See you soon!");
			System.exit(0);
		}
		//if (selectedCategory == null)
		return selectedCategory;
	}

	public Integer chooseProject(Category category, CategoryStorage categoryStorage) {
		Project project = new Project();
		System.out.println(BORDER);
		System.out.println("Current category N: " + (categoryStorage.indexOf(category) + 1)
				+ "(" + category.getName() + ")");		
		System.out.println("List of projects:");
		printProjects(category.getAll());
		System.out.println("\nChoose a project by number (first to choose another category): ");
		Integer selectedProject = consoleInspector.getCorrectInt(FIRST, 
				category.size());
		if(selectedProject == null) {
			return null;
		}		
		//project = category.get(selectedProject);
		
		//selectedProject = consoleInspector.getCorrectInt(FIRST, 
		//		categoryStorage.get(selectedCategory - SHIFT_ONE).size());
		return selectedProject;
	}
	
	public int indexOfProject(Project project) {
		return category.indexOf(project);
	}
	
	public void printCategories(List<Category> categories) {
		for(int i = 0; i < categories.size(); i++) {
			System.out.println(i + 1 + ": " + categories.get(i).getName());
		}	
	}
	
	public void printProjects(List<Project> projects) {		
		for(int i = 0; i < projects.size(); i++){			
			System.out.println("\n" + (i+1) + ":");
			ProjectManager projectManager = new ProjectManager(projects.get(i));
			projectManager.printShort(projects.get(i));
		}	
	}	

}
