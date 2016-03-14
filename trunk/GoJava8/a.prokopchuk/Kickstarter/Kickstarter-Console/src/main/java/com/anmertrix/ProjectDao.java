package com.anmertrix;

import java.util.List;

public abstract class ProjectDao {

	CategoryDao categoryDao;

	public ProjectDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public String getProjectList(int idCategory) {
		StringBuilder result = new StringBuilder();
		result.append("Please, select project or enter 0 - to exit: \n");
		Category category = categoryDao.getCategory(idCategory);
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
		Category category = categoryDao.getCategory(idCategory);
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
	
	public abstract void fillCategory();
}
