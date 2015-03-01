package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.List;


public interface Categories {

	void showAllCatecoriesInKickstarter();

	String showAllProjectInCategory(int categoryId);

	String showCatecoryName(int categoryId);

	int[] getKickCategories();

	int[] projectsThatAreContainedInTheCategory(int categoryId);

	List<Category> getCategories();
}