package com.anmertrix;

import java.util.List;

public class ProjectSource {

	CategorySource categorySource;

	public ProjectSource(CategorySource categorySource) {
		this.categorySource = categorySource;
		categorySource.getCategories().get(0).setProject(new Project("Cube soccer ball", "Test description", 5000, 1000, 12, "Test history"));
		categorySource.getCategories().get(0).setProject(new Project("La Liga Weekly Podcast", "Test description", 8000, 300, 22, "Test history"));
		categorySource.getCategories().get(1).setProject(new Project("Author’s vocabulary", "Test description", 7000, 200, 25, "Test history"));
		categorySource.getCategories().get(1).setProject(new Project("Reporter camera", "Test description", 4000, 500, 5, "Test history"));
		categorySource.getCategories().get(2).setProject(new Project("Yes Cart", "Test description", 6500, 10, 9, "Test history"));
		categorySource.getCategories().get(2).setProject(new Project("ARoglyph", "Test description", 5600, 100, 13, "Test history"));
		categorySource.getCategories().get(3).setProject(new Project("Start Control", "Test description", 8000, 300, 15, "Test history"));
		categorySource.getCategories().get(3).setProject(new Project("OldStyleRacing", "Test description", 5000, 400, 11, "Test history"));
		categorySource.getCategories().get(4).setProject(new Project("Poughkeepsie", "Test description", 5000, 400, 11, "Test history"));
		categorySource.getCategories().get(4).setProject(new Project("photobook", "Test description", 5000, 400, 11, "Test history"));
		categorySource.getCategories().get(5).setProject(new Project("Portraits & Stories", "Test description", 5000, 400, 11, "Test history"));
		categorySource.getCategories().get(5).setProject(new Project("Alzheimer", "Test description", 5000, 400, 11, "Test history"));
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
				.append("Required budget: " + project.getRequiredBudget() + "\n")
				.append("Gathered budget: " + project.getGatheredBudget() + "\n")
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
			.append("Required budget: " + project.getRequiredBudget() + "\n")
			.append("Gathered budget: " + project.getGatheredBudget() + "\n")
			.append("Days left: " + project.getDaysLeft() + "\n")
			.append("History: " + project.getHistory() + "\n")
			.append("Video URL: " + project.getURL() + "\n")
			.append("Question and answer: \n" + project.getQuestionAnswer());
		return result.toString();
	}
	
	public String getProjectMenu() {
		StringBuilder result = new StringBuilder();
		
		result.append("Please, select menu item or enter 0 - to exit: \n")
		.append("1 - Ask a question")
		.append("    ")
		.append("2 - Invest project")
		.append("    ")
		.append("3 - Return to project list");
	
		return result.toString().trim();
	}
	
	
}
