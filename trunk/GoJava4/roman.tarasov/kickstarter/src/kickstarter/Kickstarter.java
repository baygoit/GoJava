package kickstarter;

import java.util.ArrayList;
import java.util.Scanner;

public class Kickstarter {

	Category category;
	Project project;
	ArrayList<Category> categories = new ArrayList<Category>();
	ArrayList<Project> projects = new ArrayList<Project>();
	ArrayList<Project> projectsInCategory;

	Scanner scanner;

	public void start() {

		scanner = new Scanner(System.in);

		consoleCycle();
	}

	void printCategories() {
		System.out.println("Categories :");
		System.out.println("------------");
		for (int index = 0; index < categories.size(); index++) {
			category = categories.get(index);
			System.out.println(index + "- " + category.name);
		}
		System.out.println("Choise category from list:");
	}

	void consoleCycle() {

		while (true) {
			printCategories();
			try {
				String fromConsole = scanner.nextLine();
				category = parseStringToCategory(categories, fromConsole);
				System.out.println("Category : " + category.name);
				System.out.println("------------");
				printInfoAboutProjectsInCategory(getAllProjectsInCategory(category));

				fromConsole = scanner.nextLine();
				project = parseStringToProject(projectsInCategory, fromConsole);
				printInfoAboutProject(project);

			} catch (IllegalArgumentException e) {
				System.err.println("wrong choise");
			}

		}
	}

	void printInfoAboutProject(Project project) {
		System.out.println("description: "+project.description);
		System.out.println("history    : "+project.history);
	}

	Project parseStringToProject(ArrayList<Project> projects,
			String stringToParse) {
		try {
			int parsed = Integer.parseInt(stringToParse);
			project = projects.get(parsed);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		return project;

	}

	Category parseStringToCategory(ArrayList<Category> categories,
			String stringToParse) throws IllegalArgumentException {

		try {
			int parsed = Integer.parseInt(stringToParse);
			category = categories.get(parsed);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		return category;
	}

	ArrayList<Project> getAllProjectsInCategory(Category category) {
		this.projectsInCategory = new ArrayList<Project>();
		for (Project currentProject : projects) {
			if (category.name.equals(currentProject.category.name)) {
				projectsInCategory.add(currentProject);
			}
		}
		return projectsInCategory;
	}

	void printInfoAboutProjectsInCategory(ArrayList<Project> projectsInCategory) {
		Project currentProject;
		for (int index = 0; index < projectsInCategory.size(); index++) {
			currentProject = projectsInCategory.get(index);
			System.out.println(index + "- " + currentProject.name
					+ " , target amount:" + currentProject.goal
					+ "  amount collected:" + currentProject.money
					+ " , expire date:" + currentProject.expireDate);
		}
	}

	public void add(Project project) {
		projects.add(project);
	}

	public void add(Category category) {
		categories.add(category);
	}
}
