package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.List;


public interface Categories {

	void setCatecories();
	
	List<Category> getCategories();

	String showCatecoryName(int categoryId);

	int[] getKickCategories();
}