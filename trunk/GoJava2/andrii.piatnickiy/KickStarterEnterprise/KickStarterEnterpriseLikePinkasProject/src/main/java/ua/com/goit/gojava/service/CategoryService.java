package ua.com.goit.gojava.service;

import java.util.List;

import javax.transaction.Transactional;

import ognl.ListPropertyAccessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.entity.Category;
import ua.com.goit.gojava.entity.Project;
import ua.com.goit.gojava.repository.CategoryRepository;
import ua.com.goit.gojava.repository.ProjectRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRository;
	
	@Autowired
	private ProjectRepository  projectRository;
	
	public List<Category> findAll(){
		return categoryRository.findAll();
	}

	public Category findOne(int id) {
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
