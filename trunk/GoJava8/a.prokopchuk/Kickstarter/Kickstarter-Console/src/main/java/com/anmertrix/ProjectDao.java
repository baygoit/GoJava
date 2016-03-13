package com.anmertrix;

import java.util.List;

public class ProjectDao {

	CategoryDao categorySource;

	public ProjectDao(CategoryDao categorySource) {
		this.categorySource = categorySource;

		Project project1 = new Project();
		project1.setProjectData("Cube soccer ball", "Test description", 5000,
				1000, 12, "Test history");
		categorySource.getCategories().get(0).setProject(project1);

		Project project2 = new Project();
		project2.setProjectData("La Liga Weekly Podcast", "Test description",
				8000, 300, 22, "Test history");
		categorySource.getCategories().get(0).setProject(project2);

		Project project3 = new Project();
		project3.setProjectData("Author’s vocabulary", "Test description",
				7000, 200, 25, "Test history");
		categorySource.getCategories().get(1).setProject(project3);

		Project project4 = new Project();
		project4.setProjectData("Reporter camera", "Test description", 4000,
				500, 5, "Test history");
		categorySource.getCategories().get(1).setProject(project4);

		Project project5 = new Project();
		project5.setProjectData("Yes Cart", "Test description", 6500, 10, 9,
				"Test history");
		categorySource.getCategories().get(2).setProject(project5);

		Project project6 = new Project();
		project5.setProjectData("ARoglyph", "Test description", 5600, 100, 13,
				"Test history");
		categorySource.getCategories().get(2).setProject(project6);

		Project project7 = new Project();
		project7.setProjectData("Start Control", "Test description", 8000, 300,
				15, "Test history");
		categorySource.getCategories().get(3).setProject(project7);

		Project project8 = new Project();
		project8.setProjectData("OldStyleRacing", "Test description", 5000,
				400, 11, "Test history");
		categorySource.getCategories().get(3).setProject(project8);

		Project project9 = new Project();
		project9.setProjectData("Poughkeepsie", "Test description", 5000, 400,
				11, "Test history");
		categorySource.getCategories().get(4).setProject(project9);

		Project project10 = new Project();
		project10.setProjectData("photobook", "Test description", 5000, 400,
				11, "Test history");
		categorySource.getCategories().get(4).setProject(project10);

		Project project11 = new Project();
		project11.setProjectData("Portraits & Stories", "Test description",
				5000, 400, 11, "Test history");
		categorySource.getCategories().get(4).setProject(project11);

		Project project12 = new Project();
		project12.setProjectData("Alzheimer", "Test description", 5000, 400,
				11, "Test history");
		categorySource.getCategories().get(4).setProject(project12);

	}

	public String getProjectList(int idCategory) {
		StringBuilder result = new StringBuilder();
		result.append("Please, select project or enter 0 - to exit: \n");
		Category category = categorySource.getCategory(idCategory);
		List<Project> projects = category.getProjects();

		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			result.append(i + 1)
					.append(" - ")
					.append(project.getName() + "\n")
					.append("Description: " + project.getDescription() + "\n")
					.append("Required budget: " + project.getRequiredBudget()
							+ "\n")
					.append("Gathered budget: " + project.getGatheredBudget()
							+ "\n")
					.append("Days left: " + project.getDaysLeft())
					.append("\n" + "\n");
		}

		return result.toString().trim();
	}

	public String getInfoSelectedProject(int idCategory, int idProject) {
		Category category = categorySource.getCategory(idCategory);
		List<Project> projects = category.getProjects();
		Project project = projects.get(idProject);

		StringBuilder result = new StringBuilder();
		result.append(project.getName() + "\n")
				.append("Description: " + project.getDescription() + "\n")
				.append("Required budget: " + project.getRequiredBudget()
						+ "\n")
				.append("Gathered budget: " + project.getGatheredBudget()
						+ "\n")
				.append("Days left: " + project.getDaysLeft() + "\n")
				.append("History: " + project.getHistory() + "\n")
				.append("Video URL: " + project.getURL() + "\n")
				.append("Question and answer: \n" + project.getQuestionAnswer());
		return result.toString();
	}

	public String getProjectMenu() {
		StringBuilder result = new StringBuilder();

		result.append("Please, select menu item or enter 0 - to exit: \n")
				.append("1 - Ask a question").append("    ")
				.append("2 - Invest project").append("    ")
				.append("3 - Return to project list");

		return result.toString().trim();
	}

}
