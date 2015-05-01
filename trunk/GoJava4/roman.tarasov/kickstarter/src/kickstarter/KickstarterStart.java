package kickstarter;

import java.util.ArrayList;

public class KickstarterStart {
	static ArrayList<Category> listCategories = new ArrayList<Category>();
	static ArrayList<Project> listProjects = new ArrayList<Project>();
	static ArrayList<User> listUsers = new ArrayList<User>();
	static ArrayList<Citation> listCitation = new ArrayList<Citation>();

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		KickstarterStart starter = new KickstarterStart();

		starter.createProjects();
		starter.createCategories();
		starter.createCitation();
		starter.createUser();
		kickstarter
				.start(listCategories, listProjects, listCitation, listUsers);
	}

	public void createCitation() {
		String[] citation = { "null", "Do It", "Go IT", "Create It" };
		for (int index = 0; index < citation.length; index++) {
			Citation current = new Citation(index);
			current.setText(citation[index]);
			listCitation.add(current);
		}
	}

	public void createUser() {
		String[] users = { "anonymous", "Mike", "Andy" };
		for (int index = 0; index < users.length; index++) {
			User current = new User(index);
			current.setName(users[index]);
			listUsers.add(current);
		}
	}

	public void createCategories() {
		String[] categories = { "null", "Technology", "Social", "Education" };

		for (int index = 0; index < categories.length; index++) {
			Category current = new Category(index);
			current.setName(categories[index]);
			listCategories.add(current);
		}
	}

	public void createProjects() {
		String[] projects = { "null", "Create electrobike", "Paint the fence",
				"Java Architect Training", "Create quadrocopter" };
		for (int index = 0; index < projects.length; index++) {
			Project current = new Project(index);
			current.setName(projects[index]);
			listProjects.add(current);
		}
	}
}
