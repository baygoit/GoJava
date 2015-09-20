package goit.nz.kickstarter.dao;

import goit.nz.kickstarter.domain.Category;

import java.util.List;

public interface CategoryDAO {

	abstract List<Category> getCategories();

	abstract Category getCategory(long categoryId);

}