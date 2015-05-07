package kickstarter;

public class KickstarterStart {

	public static void main(String[] args) {

		Kickstarter kickstarter = new Kickstarter();
		CategoryList categories = new CategoryList();
		ProjectList projects = new ProjectList();
		Project project;
		Category category = new Category("Social");

		categories.addCategory(category);
		
		 project = new Project("Paint the fence of the school", category);
		  project.description = "raising money for paint";
		  projects.addProject(project);
		 
		category = new Category("Technology");
		categories.addCategory(category);

		project = new Project("Create electrobike", category);
		project.description = "high efficiency";
		project.history = "history of bike creation";
		project.pledged = 25;
		project.goal = 2000;
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
