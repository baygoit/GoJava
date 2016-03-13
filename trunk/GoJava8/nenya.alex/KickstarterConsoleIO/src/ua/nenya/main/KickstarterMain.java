package ua.nenya.main;




import java.util.List;

import ua.nenya.builders.ProjectBuilder;
import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.file.CategoryDaoFileImpl;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.project.Category;
import ua.nenya.project.Projects;
import ua.nenya.users.User;
import ua.nenya.users.Users;
import ua.nenya.util.ConsoleIOImpl;
import ua.nenya.util.IO;

public class KickstarterMain {

	public static void main(String[] args) {

		IO io = new ConsoleIOImpl();
		
//		CategoryDaoMemoryImpl categoryInit = new CategoryDaoMemoryImpl();
//		categoryInit.initCategories();
//		List<Category> categories = categoryInit.getCategories();
		
		CategoryDaoFileImpl categoryInit = new CategoryDaoFileImpl();
		categoryInit.initCategories();
		List<Category> categories = categoryInit.getCategories();
		
		Users userInit = new Users();
		userInit.init();
		List<User> users = userInit.getUsers();
		
		Projects projects = setupProjects(categories).getProject();

		new Kickstarter(users, categories, projects, io).run();
	}

	private static ProjectBuilder setupProjects(List<Category> categories) {
		ProjectBuilder builder = new ProjectBuilder();
		builder.add("A new funny song", "We want to write a new funny song!",
				2000, 1000, 7, categories.get(0));
		builder.add("A lonly song", "We want to write a new sad song!", 400,
				10, 3, categories.get(0));
		builder.add("Terminator 88",
				"All money we'll gather is for new blockbuster!", 200000, 1000,
				365, categories.get(1));
		builder.add("Dirty Garry", "It'll be a western about wild west!",
				10000, 3000, 150, categories.get(1));
		builder.add("True Maidan Story",
				"It's book about events in 2013-1014 years in Ukraine!",
				158200, 45123, 78, categories.get(2));
		builder.add("My way",
				"Book about 4th President of Ukraine in politics!", 200, 5, 12,
				categories.get(2));
		builder.add("Exhibition of photos", "Exhibition of photos of Kiev!",
				7000, 1000, 15, categories.get(3));
		builder.add("Exhibition of plates", "Exhibition of old plates!",
				100000, 7000, 120,
				categories.get(3));
		builder.add("Diablo 4", "New PC game!", 1000000, 10000, 765,
				categories.get(4));
		builder.add("Sims'5", "New board game!", 500000, 100000, 400,
				categories.get(4));
		return builder;

	}
}
