package ua.nenya.alex.builders;

import java.util.List;

import ua.nenya.alex.enums.CategoriesEnum;
import ua.nenya.alex.project.Category;

public class CategoryBuilder {
	Category category;

	public Category getCategory() {
		return category;
	}

	public CategoryBuilder() {
		this.category = new Category();
	}

	public void createAll(List<CategoriesEnum> list) {
		for (CategoriesEnum name : list) {
			category.getCategoriesList().add(new Category(name.getName()));
		}
	}

}
