package ua.nenya.main;

import java.util.List;

import ua.nenya.project.Category;
import ua.nenya.project.User;
import ua.nenya.util.ConsoleIOImpl;
import ua.nenya.util.IO;
import ua.nenya.dao.QuoteDao;
import ua.nenya.dao.db.CategoryDaoDbImpl;
import ua.nenya.dao.db.QuoteDaoDbImpl;
import ua.nenya.dao.db.UserDaoDbImpl;
import ua.nenya.dao.file.CategoryDaoFileImpl;
import ua.nenya.dao.file.QuoteDaoFileImpl;
import ua.nenya.dao.file.UserDaoFileImpl;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.dao.memory.QuoteDaoMemoryImpl;
import ua.nenya.dao.memory.UserDaoMemoryImpl;

public class KickstarterMain {

	public static void main(String[] args) {
		String switcher = System.getenv("ENTERING_MODE");
		//System.out.println(switcher);
		IO io = new ConsoleIOImpl();
		List<User> users;
		List<Category> categories;
		QuoteDao quoteInit;

		if (switcher.equals("db")) {
			//System.out.println("FromDB");

			quoteInit = new QuoteDaoDbImpl();
			quoteInit.initQuotes();
			
			UserDaoDbImpl userInit = new UserDaoDbImpl();
			userInit.initUsers();
			users = userInit.getUsers();

			CategoryDaoDbImpl categoryInit = new CategoryDaoDbImpl();
			categoryInit.initCategories();
			categories = categoryInit.getCategories();
		} else {
			if (switcher.equals("file")) {
				//System.out.println("FromFile");

				quoteInit = new QuoteDaoFileImpl();
				quoteInit.initQuotes();
				
				UserDaoFileImpl userInit = new UserDaoFileImpl();
				userInit.initUsers();
				users = userInit.getUsers();

				CategoryDaoFileImpl categoryInit = new CategoryDaoFileImpl();
				categoryInit.initCategories();
				categories = categoryInit.getCategories();
			} else {
				//System.out.println("FromMemory");

				quoteInit = new QuoteDaoMemoryImpl();
				quoteInit.initQuotes();
				
				UserDaoMemoryImpl userInit = new UserDaoMemoryImpl();
				userInit.initUsers();
				users = userInit.getUsers();

				CategoryDaoMemoryImpl categoryInit = new CategoryDaoMemoryImpl();
				categoryInit.initCategories();
				categories = categoryInit.getCategories();
			}
		}

		new Kickstarter(quoteInit, users, categories, io).run();
	}

}
