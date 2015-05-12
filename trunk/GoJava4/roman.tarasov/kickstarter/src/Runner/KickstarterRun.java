package Runner;

import kickstarter.Kickstarter;
import kickstarter.Entities.Category;
import kickstarter.Entities.Project;
import kickstarter.Repository.CategoryList;
import kickstarter.Repository.ProjectList;

public class KickstarterRun {

	public static void main(String[] args) {

		Kickstarter kickstarter = new Kickstarter();
		CategoryList categories = new CategoryList();
		ProjectList projects = new ProjectList();
		Project project;
		Category category = new Category("Social");
		category.id = 2;
		categories.addCategory(category);

		project = new Project("Paint the fence of the school", category);
		project.description = "raising money for paint";
		project.id = 8;
		projects.addProject(project);

		category = new Category("Technology");
		category.id = 5;
		categories.addCategory(category);

		project = new Project("Create electrobike", category);
		project.description = "high efficiency";
		project.history = "history of bike creation";
		project.pledged = 25;
		project.goal = 2000;
		project.id = 23;
		projects.addProject(project);

		project = new Project("Create quadrocopter", category);
		project.id = 4;
		projects.addProject(project);

		/*
		 * category = new Category("Technology"); kickstarter.add(category);
		 * project = new Project("Create quadrocopter", category);
		 * kickstarter.add(project);
		 */
		kickstarter.add(categories);
		kickstarter.add(projects);
		kickstarter.start();
	}
}
