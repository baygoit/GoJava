package ua.com.goit.gojava.service;

import java.util.List;

import javax.transaction.Transactional;

import ognl.ListPropertyAccessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.entity.Category;
import ua.com.goit.gojava.entity.Project;
import ua.com.goit.gojava.repository.CategoryRository;
import ua.com.goit.gojava.repository.ProjectRository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRository categoryRository;
	
	@Autowired
	private ProjectRository  projectRository;
	
	public List<Category> findAll(){
		return categoryRository.findAll();
	}

	public Category findOne(int id) {
		// TODO Auto-generated method stub
		return categoryRository.findOne(id);
	}
	
	@Transactional
	public Category findOneWithProject(int id) {
		Category category = findOne(id);
		List<Project> projects =  projectRository.findByCategory(category);
		category.setProjects(projects);
		return category;
	}
}
