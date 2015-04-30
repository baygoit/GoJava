package kickstarter;

import java.util.ArrayList;

public class KickstarterStart {
	static ArrayList<Category> listCategories = new ArrayList<Category>();
	static ArrayList<Project> listProjects = new ArrayList<Project>();

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		KickstarterStart starter = new KickstarterStart();

		starter.initProjects();
		starter.initCategories();

		kickstarter.start(listCategories, listProjects);
	}

	public void initProjects() {
		String[] projects = { "Create electrobike", "Paint the fence",
				"Java Architect Training" };
		for (int index = 0; index < projects.length; index++) {
			Project current = new Project();
			current.setName(projects[index]);
			current.id = index + 1;
			listProjects.add(current);
		}
	}

	public void initCategories() {
		String[] categories = { "Technology", "Social", "Education" };

		for (int index = 0; index < categories.length; index++) {
			Category current = new Category();
			current.setName(categories[index]);
			current.id = index + 1;
			listCategories.add(current);
		}

	}
}
