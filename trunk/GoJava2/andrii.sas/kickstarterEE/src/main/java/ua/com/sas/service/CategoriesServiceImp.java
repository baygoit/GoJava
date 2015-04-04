package ua.com.sas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.model.Category;

@Service
@Transactional
public class CategoriesServiceImp implements CategoriesService{
	
	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Override
	public Category getWithProjects(int id) {
		Category category = categoriesDAO.get(id);
		category.getProjects().size();
		return category;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = categoriesDAO.getCategories();
		return categories;
	}
}
