package ua.com.goit.gojava2.vova.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava2.vova.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao dao;
	
	@Override
	public void saveCategory(Category category) {
		dao.saveCategory(category);
	}

	@Override
	public List<Category> findAllCategories() {
		return dao.findAllCategories();
	}

	@Override
	public void deleteCategoryById(int id) {
		dao.deleteCategoryById(id);
	}

	@Override
	public Category getCategoryById(int id) {
		return dao.findCategoryById(id);
	}

}
