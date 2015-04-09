package ua.com.goit.gojava.kickstarter.data;

import java.util.List;

import ua.com.goit.gojava.kickstarter.dao.ProjectsDao;

public interface CategoryCatalog {

	void add(Category category);

	List<Category> getCatalog();

	Category get(int id);

	int size();

}