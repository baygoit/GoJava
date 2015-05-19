package ua.com.sas.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.dao.ProjectsDAO;
import ua.com.sas.dao.QuotesDAO;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.model.Quote;

@Service
@Transactional
public class ProjectsServiceImp implements ProjectsService{
	
	@Autowired
	private ProjectsDAO projectsDAO;
	
	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Autowired
	private QuotesDAO quotesDAO;
	
	@Override
	public void addCategory(Category category) {
		categoriesDAO.add(category);
	}

	@Override
	public Project getCurrent(int id) {
		Project project = projectsDAO.get(id);
		project.getCategory().getId();
		return project;
	}
	
	@Override
	public Category getWithProjects(int id) {
		Category category = categoriesDAO.get(id);
		category.getProjects().size();
		return category;
	}

	@Override
	public List<Category> getAll() {
		return categoriesDAO.getCategories();
	}

	@Override
	public Quote getRandomed(Random random) {
		int rand = random.nextInt(quotesDAO.size()) + 1;
		return quotesDAO.get(rand);
	}
	
}
