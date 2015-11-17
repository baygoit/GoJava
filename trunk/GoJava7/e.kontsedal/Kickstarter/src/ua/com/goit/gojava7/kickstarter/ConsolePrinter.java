package ua.com.goit.gojava7.kickstarter;

import java.util.Map;

public class ConsolePrinter {
	private static final String N = "\n";
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
			
			System.out.println("========================" + N + (i + 1) + " : "
					+ currentProject.getProjectName() + N
					+ currentProject.getProjectShortDescription() + N
					+ currentProject.getProjectCostNeed() + N
					+ currentProject.getProjectCostCollected() + N
					+ currentProject.getProjectDaysLeft() + N 
					+ "========================");
		}
	}

	public void println(Project project) {
		System.out.println(project.getProjectDescription() + N
				+ project.getProjectCostNeed() + N
				+ project.getProjectCostCollected() + N
				+ project.getProjectDaysLeft() + N
				+ project.getVideoUrl()
				);
		for (Map.Entry<String, String> entry : project.getQuestionsAndAnswer().entrySet()) {
			System.out.println(entry.getKey() + N + entry.getValue());
		}

	}
}
