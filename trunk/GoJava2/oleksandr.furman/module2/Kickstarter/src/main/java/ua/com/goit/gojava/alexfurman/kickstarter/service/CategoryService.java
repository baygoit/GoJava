package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Category;
import ua.com.goit.gojava.alexfurman.kickstarter.dao.CategoryDAO;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}
}