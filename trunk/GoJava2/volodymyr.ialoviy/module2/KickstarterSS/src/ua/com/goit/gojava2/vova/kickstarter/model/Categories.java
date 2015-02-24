package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.ArrayList;

public interface Categories {

	void writeAllCatecories();

	String showAllCatecoriesInKickstarter();

	String showAllProjectInCategory(int categoryId,	Projects projects);

	String showCatecoryName(int categoryId);

	int[] getKickCategories();

	int[] projectsThatAreContainedInTheCategory(int categoryId);

	int getCounterCategory();

	void setCounterCategory(int counterCategory);

	ArrayList<Category> getListCatecories();

	void setListCatecories(ArrayList<Category> listCatecories);

}