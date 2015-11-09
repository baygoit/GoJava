package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;



public class CategoryStorage {

	static List<Category> categorylist = new ArrayList<>();

	private static  List<Category> listFiller() {

		categorylist.add(new Category("it", 1));
		categorylist.add(new Category("it", 1));
		categorylist.add(new Category("education", 2));
		categorylist.add(new Category("sport", 3));
		return categorylist ;

	}

	public static List<Category> getCategories() {

		return listFiller();

	}

	public static Category getCategoriesByNumber(int number) {

		return listFiller().get(number);

	}

}
