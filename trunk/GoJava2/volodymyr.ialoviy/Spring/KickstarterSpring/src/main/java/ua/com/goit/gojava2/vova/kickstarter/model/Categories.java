package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.List;

public interface Categories {

	List<Category> getCategories();

	String showCatecoryName(int categoryId);
}