package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.Category;
import com.anmertrix.Project;

public abstract class ProjectDao {

	protected CategoryDao categoryDao;
	protected static final String SOLID_LINE = "─────────────────────────────────────────";

	public ProjectDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public String getProjectList(int idCategory) {
		StringBuilder result = new StringBuilder();
		Category category = categoryDao.getCategory(idCategory);
		List<Project> projects = category.getProjects();

		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			result.append(i + 1)
					.append(" - ")
					.append(project.getName() + "\n");
		}
		result.append("0 - EXIT \n")
			.append("\n")
			.append("Please, select project...");
		return result.toString().trim();
	}

	public String getInfoSelectedProject(int idCategory, int idProject) {
		Category category = categoryDao.getCategory(idCategory);
		List<Project> projects = category.getProjects();
		Project project = projects.get(idProject);

		StringBuilder result = new StringBuilder();
		result.append(project.getName() + "\n")
				.append(SOLID_LINE + "\n")
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

		result.append("1 - Ask a question").append("    ")
				.append("2 - Invest project").append("    ")
				.append("3 - Rewards").append("    ")
				.append("0 - EXIT")
				.append("\n \n")
				.append("Please, select menu item...");

		return result.toString().trim();
	}
	
	public abstract void fillCategory();
	
}
