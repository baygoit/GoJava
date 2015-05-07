package kickstarter;

public class KickstarterStart {

	public static void main(String[] args) {

		Kickstarter kickstarter = new Kickstarter();
		CategoryList categories =new CategoryList();

		Category category = new Category("Social");
		categories.addCategory(category);
		
		category = new Category("Technology");
		categories.addCategory(category);
		
		category = new Category("Technology");
		categories.addCategory(category);
		
		kickstarter.add(categories);
/*		
		Project project = new Project("Paint the fence", category);
		project.description = "help";
		kickstarter.add(project);

		category = new Category("Technology");
		kickstarter.add(category);
		project = new Project("Create electrobike", category);
		project.description = "high efficiency";
		project.history = "history of bike creation";
		project.pledged = 25;
		project.goal = 2000;
		kickstarter.add(project);

		category = new Category("Technology");
		kickstarter.add(category);
		project = new Project("Create quadrocopter", category);
		kickstarter.add(project);
*/
		kickstarter.start();
	}
}
