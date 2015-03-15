package ua.com.goit.gojava.kickstarter.data;

import java.util.List;

import ua.com.goit.gojava.kickstarter.dao.ProjectsDao;

public interface CategoryCatalog {

	void addCategory(String name);

	List<Category> getCatalog();

	Category getCategory(int id);

	int size();

}