package goit.nz.kickstarter.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.domain.Category;

public class CategoryService {
	private CategoryDAO categoryDAO;

	public CategoryService(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}

	@Transactional(readOnly = true)
	public Category getCategory(long categoryId) {
		return categoryDAO.getCategory(categoryId);
	}
}
