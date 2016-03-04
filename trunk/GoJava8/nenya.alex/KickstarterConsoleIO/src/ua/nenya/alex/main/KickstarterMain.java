package ua.nenya.alex.main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.nenya.alex.builders.CategoryBuilder;
import ua.nenya.alex.builders.ProjectBuilder;
import ua.nenya.alex.builders.UserBuilder;
import ua.nenya.alex.enums.CategoriesEnum;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.users.User;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ConsoleIOImpl;

public class KickstarterMain {

	public static void main(String[] args) {

		IO io = new ConsoleIOImpl();
		Category category = setupCategories();
		Project project = setupProjects(category).getProject();
		User user = setupUsers();

		new Kickstarter(category, project, io, user).run();
	}

	private static Category setupCategories() {
		CategoryBuilder categoryBuilder = new CategoryBuilder();
		List<CategoriesEnum> list = new ArrayList<>(Arrays.asList(CategoriesEnum.values()));
		categoryBuilder.createAll(list);

		return categoryBuilder.getCategory();

	}

	private static User setupUsers() {
		UserBuilder userBuilder = new UserBuilder();
		userBuilder.createAll("users.txt");
		return userBuilder.getUser();
	}

	private static ProjectBuilder setupProjects(Category category) {
		ProjectBuilder builder = new ProjectBuilder();
		builder.add("A new funny song", "We want to write a new funny song!",
				2000, 1000, 7, category.getCategoriesList().get(0));
		builder.add("A lonly song", "We want to write a new sad song!", 400,
				10, 3, category.getCategoriesList().get(0));
		builder.add("Terminator 88",
				"All money we'll gather is for new blockbuster!", 200000, 1000,
				365, category.getCategoriesList().get(1));
		builder.add("Dirty Garry", "It'll be a western about wild west!",
				10000, 3000, 150, category.getCategoriesList().get(1));
		builder.add("True Maidan Story",
				"It's book about events in 2013-1014 years in Ukraine!",
				158200, 45123, 78, category.getCategoriesList().get(2));
		builder.add("My way",
				"Book about 4th President of Ukraine in politics!", 200, 5, 12,
				category.getCategoriesList().get(2));
		builder.add("Exhibition of photos", "Exhibition of photos of Kiev!",
				7000, 1000, 15, category.getCategoriesList().get(3));
		builder.add("Exhibition of plates", "Exhibition of old plates!",
				100000, 7000, 120,
				category.getCategoriesList().get(3));
		builder.add("Diablo 4", "New PC game!", 1000000, 10000, 765,
				category.getCategoriesList().get(4));
		builder.add("Sims'5", "New board game!", 500000, 100000, 400,
				category.getCategoriesList().get(4));
		return builder;

	}
}
