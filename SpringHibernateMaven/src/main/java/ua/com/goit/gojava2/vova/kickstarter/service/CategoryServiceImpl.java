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
	
	public void saveCategory(Category category) {
		dao.saveCategory(category);
	}

	public List<Category> findAllCategories() {
		return dao.findAllCategories();
	}

	public void deleteCategoryById(Integer id) {
		dao.deleteCategoriesById(id);
	}

}
