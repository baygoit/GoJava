package ua.com.sas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.dao.ProjectsDAO;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;

@Service
@Transactional
public class ProjectsServiceImp implements ProjectsService{
	
	@Autowired
	private ProjectsDAO projectsDAO;
	
	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Override
	public Project getCurrent(int id) {
		return projectsDAO.get(id);
	}
	
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
