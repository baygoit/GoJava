package kickstarter;

import java.util.ArrayList;

public class KickstarterStart {
	Repository repository;
	Citation citations;
	User users;
	Category categories;
	Project projects;

	public static void main(String[] args) {

		KickstarterStart starter = new KickstarterStart();
		starter.createProjects();
		starter.createCategories();
		starter.createCitations();
		starter.createUsers();
	}

	public void createCitations() {
		citations = new Citation(repository);
	}

	public void createUsers() {
		users = new User(repository);
	}

	public void createCategories() {
		categories = new Category(repository);
	}

	public void createProjects() {
		projects = new Project(repository);
	}

	public void start() {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.start(categories, projects, citations, users);
	}
}
