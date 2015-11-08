package ua.goit.web.model.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.goit.web.model.dao.Category;


public class MCategoryDao   {
	List<Category> categories;

	public MCategoryDao() {
		categories = new ArrayList<Category>();

		Category category = new Category();
		category.setID(5);
		category.setName("Technology");
		categories.add(category);

		category = new Category();
		category.setID(4);
		category.setName("Social");
		categories.add(category);
	}

	public List<Category> getAllCategories() {
		return categories;
	}
}
