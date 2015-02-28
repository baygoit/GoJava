package ua.com.goit.gojava.kickstarter.data;

import java.util.List;

public interface CategoryCatalog {

	void addCategory(String name);

	List<String> getCatalog();

	Category getCategory(int id);

	int size();

}