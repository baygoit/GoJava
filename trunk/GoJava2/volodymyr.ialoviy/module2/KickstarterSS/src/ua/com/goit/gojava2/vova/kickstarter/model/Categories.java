package ua.com.goit.gojava2.vova.kickstarter.model;


public interface Categories {

	String showAllCatecoriesInKickstarter();

	String showAllProjectInCategory(int categoryId);

	String showCatecoryName(int categoryId);

	int[] getKickCategories();

	int[] projectsThatAreContainedInTheCategory(int categoryId);
}