package ua.com.goit.gojava.kickstarter;


import java.util.List;

public interface CategoryCatalog {

	void addCategory(String name);

	List<String> getCatalog();

	Category getCategory(int i);

	int size();

}