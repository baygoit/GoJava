package ua.com.sas.service;

import java.util.Arrays;
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
		List<Category> categories = categoriesDAO.getCategories();
		return categories;
	}
	
	@Override
	public void createDummyCategoryWithProject() {
		Category category = new Category();
		category.setName("new category");
		
		Project project = new Project();
		project.setName("new project");
		project.setDescription("descr");
		project.setDaysLeft(0);
		project.setHistory("");
		project.setMoneyHas(0);
		project.setMoneyNeed(0);

//		1st method
//		categoriesDAO.add(category);
//		project.setCategory(category);
//		projectsDAO.add(project);
//		2 method
		category.setProjects(Arrays.asList(project));
		project.setCategory(category);
		categoriesDAO.add(category);
	}
	
}
