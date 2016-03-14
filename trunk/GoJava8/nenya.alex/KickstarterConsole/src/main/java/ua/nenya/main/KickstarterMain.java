package ua.nenya.main;

import java.util.List;

import ua.nenya.project.Category;
import ua.nenya.project.User;
import ua.nenya.util.ConsoleIOImpl;
import ua.nenya.util.IO;
import ua.nenya.dao.file.CategoryDaoFileImpl;
import ua.nenya.dao.file.UserDaoFileImpl;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.dao.memory.UserDaoMemoryImpl;

public class KickstarterMain {

	public static void main(String[] args) {
		String switcher = System.getenv("K");
		System.out.println(switcher);
		IO io = new ConsoleIOImpl();
		List<User> users;
		List<Category> categories;
		
		if (switcher.equals("memory")) {
			CategoryDaoMemoryImpl categoryInit = new CategoryDaoMemoryImpl();
			categoryInit.initCategories();
			categories = categoryInit.getCategories();

			UserDaoMemoryImpl userInit = new UserDaoMemoryImpl();
			userInit.initUsers();
			users = userInit.getUsers();
		} else {

			CategoryDaoFileImpl categoryInit = new CategoryDaoFileImpl();
			categoryInit.initCategories();
			categories = categoryInit.getCategories();

			UserDaoFileImpl userInit = new UserDaoFileImpl();
			userInit.initUsers();
			users = userInit.getUsers();
		}

		new Kickstarter(users, categories, io).run();
	}

}
