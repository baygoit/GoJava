package ua.com.goit.gojava7.kickstarter;

public class ConsolePrinter {

	public void println(String string) {
		System.out.println(string);
	}

	public void println(Category category) {
		System.out.println("=======\n" + category.getName() + "\n=======");
	}

	public void println(CategoryStorage categoryStorage) {
		for (int i = 0; i < categoryStorage.getAllCategories().size(); i++) {
			System.out.println((i + 1) + " : "
					+ categoryStorage.getCategory(i + 1).getName());
		}
	}

	public void println(CategoryStorage categoryStorage, int numberOfCategory) {
		Category projects = categoryStorage.getCategory(numberOfCategory);
		for (int i = 0; i < projects.getAllProjectsInCategory().size(); i++) {
			Project currentProject = projects.getAllProjectsInCategory().get(i);
			String n = "\n";
			System.out.println("========================\n" + (i + 1) + " : "
					+ currentProject.getProjectName() + n
					+ currentProject.getProjectShortDescription() + n
					+ currentProject.getProjectCostNeed() + n
					+ currentProject.getProjectCostCollected() + n
					+ currentProject.getProjectDaysLeft() + n 
					+ "========================");
		}
	}

	public void println(Project project) {
		System.out.println(project.getProjectShortDescription());

	}
}
