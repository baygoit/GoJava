package kickstarter.service;

import java.util.List;

import kickstarter.dao.CategoryDAO;
import kickstarter.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CategoryService")
public class CategoryService {

	@Autowired
	protected CategoryDAO dao;

	public List<Category> findAll() {
		return this.dao.findAll();
	}
}
