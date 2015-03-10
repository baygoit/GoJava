package ua.com.goit.gojava.kickstarter.data;

import java.util.List;

import ua.com.goit.gojava.kickstarter.dao.CategoryDao;

public interface CategoryCatalog {

	void addCategory(String name);

	List<Category> getCatalog();

	CategoryDao getCategory(int id);

	int size();

}