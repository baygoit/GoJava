package ua.goit.web.model.dao;

import java.util.ArrayList;
import java.util.List;


public class MemoryCategoryDao   {
	List<Category> categories;

	public MemoryCategoryDao() {
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
