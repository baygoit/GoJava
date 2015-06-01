package ua.com.gojava4.kickstarter.model.repositories;

import java.util.ArrayList;
import java.util.List;

import ua.com.gojava4.kickstarter.entities.Category;

public class CategoriesRepository {

	Repository repository;
	List<Category> categories;

	CategoriesRepository(Repository repository) {
		this.repository = repository;
		categories = new ArrayList<>();
		initialize();
	}

	public Category getByName(String inputCategory) {
		for (Category currentCategory : categories) {
			if (currentCategory.getName().equals(inputCategory)){
				return currentCategory;
			}
		}
		return null;
	}

	private void initialize() {
		categories = repository.getAllCategories();
	}

}
