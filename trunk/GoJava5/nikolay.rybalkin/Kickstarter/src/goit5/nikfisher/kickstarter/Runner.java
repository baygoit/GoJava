package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsole;

import java.util.Random;

public class Runner {

	public static void main(String[] args){

		Category category1 = new Category("Game");
		Category category2 = new Category("Design");
		Category category3 = new Category("Technology");

		Categories categories = getCategories(category1, category2, category3);

		Project project1 = new Project("Game \"Popcorn\"", 10000, 0, 10, "Interesting game");
		Project project2 = new Project("Design \"New Design\"", 10000, 0, 10, "New innovation design");
		Project project3 = new Project("Technology \"Wi-Fi\"", 10000, 0, 10, "New technology");
		Project project4 = new Project("Game1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
		Project project5 = new Project("Design1 \"New Design\"", 10000, 0, 10, "New innovation design");
		Project project6 = new Project("Technology1 \"Wi-Fi\"", 10000, 0, 10, "New technology");

		SerProjectsInCategory(category1,
							  category2,
							  category3,
							  project1,
							  project2,
							  project3,
							  project4,
							  project5,
							  project6);

		Projects projects = getProjects(project1,
										project2,
										project3,
										project4,
										project5,
										project6);

		Main app = new Main(categories, projects, new InputOutputConsole(), new QuoteGenerate(new Random()));
		app.run();
	}

	private static Projects getProjects(Project project1,
										Project project2,
										Project project3,
										Project project4,
										Project project5,
										Project project6) {

		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		projects.add(project3);
		projects.add(project4);
		projects.add(project5);
		projects.add(project6);

		SetElementsInProject.setHistoryInProject(project1, project2, project3, project4, project5, project6);
		SetElementsInProject.SetVideoInProject(project1, project2, project3, project4, project5, project6);
		SetElementsInProject.SetQuestionsInProject(project1, project2, project3, project4, project5, project6);
		SetElementsInProject.SetAnsverInProject(project1, project2, project3, project4, project5, project6);

		return projects;
	}

	private static void SerProjectsInCategory(Category category1,
											  Category category2,
											  Category category3,
											  Project project1,
											  Project project2,
											  Project project3,
											  Project project4,
											  Project project5,
											  Project project6) {
		project1.setCategory(category1);
		project2.setCategory(category2);
		project3.setCategory(category3);
		project4.setCategory(category1);
		project5.setCategory(category2);
		project6.setCategory(category3);
	}

	private static Categories getCategories(Category category1, Category category2, Category category3) {
		Categories categories = new Categories();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		return categories;
	}
}
