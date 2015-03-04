package ua.com.sas.model;

import java.util.List;

public interface Categories {

	void addCategory(Category category);

	List<Category> getCategories();

	Category readCategory(int index);

	int getLenth();

}