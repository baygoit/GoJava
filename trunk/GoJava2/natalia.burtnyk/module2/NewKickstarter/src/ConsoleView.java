import java.util.List;

public class ConsoleView {

	private List<Project> projects;
	private Сategory сategory;
	private StorageController controller;
	
	private String greating = " Welcome to Kickstarter";
	
	public ConsoleView() {
		controller = new StorageController();
	}
	
	public void displayWelcome() {
		System.out.println(greating + "\n"
				+ "  *** *** *** *** *** " + "\n"
				+ controller.getRandomQuoteToView() + "\n"
				+ "  *** *** *** *** *** ");
	}
	
	public void displayListCategories() {
		int i = 1;
		for (Сategory сategory: controller.getListCategories()) {
			System.out.println(i + ". " + сategory.getName());
			i++;
		}
	}
	
	public void displaySelectedCategory(int i) {
		сategory = controller.getListCategories().get(i - 1);
		System.out.println("Your choise: " + сategory.getName());
	}
	
	public void displayProjectsOfCategory() {		
		System.out.println("\n---- Here are the projects ----");
		projects = controller.getSpecificProjects(сategory);
		for (Project project: projects) {
			System.out.print(project.shortInfo() + "\n"
					+ "----------------------------" + "\n");
		}
	}
	
	public void displayCurrentProject(int i){
		System.out.print(projects.get(i - 1).allInfo() + "\n"
				+ "----------------------------" + "\n");
	}		
}