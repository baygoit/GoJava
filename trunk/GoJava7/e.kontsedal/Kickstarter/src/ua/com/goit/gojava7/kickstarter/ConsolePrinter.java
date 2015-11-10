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
			System.out.println("========================\n" + (i + 1) + " : "
					+ projects.getAllProjectsInCategory().get(i)
							.getProjectName()
					+ "\n"
					+ projects.getAllProjectsInCategory().get(i)
							.getProjectShortDescription()
					+ "\n"
					+ projects.getAllProjectsInCategory().get(i)
							.getProjectCostNeed()
					+ "\n"
					+ projects.getAllProjectsInCategory().get(i)
							.getProjectCostCollected()
					+ "\n"
					+ projects.getAllProjectsInCategory().get(i)
							.getProjectDaysLeft()
					+ "\n" + "========================");
		}
	}

	public void println(Project project) {
		System.out.println(project.getProjectShortDescription());

	}
}
