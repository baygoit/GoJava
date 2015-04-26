package ua.com.goit.gojava.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.entity.Category;
import ua.com.goit.gojava.entity.Project;
import ua.com.goit.gojava.repository.CategoryRository;
import ua.com.goit.gojava.repository.ProjectRository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private CategoryRository categoryRository;
	
	@Autowired
	private ProjectRository projectRository;
	
	@PostConstruct
	public void init(){
		Category category1 = new Category();
		category1.setName("Sport");
		categoryRository.save(category1);
		
		Category category2 = new Category();
		category2.setName("Car");
		categoryRository.save(category2);
		
		
		Project project1 = new Project();
		project1.setName("Bycicle");
		project1.setCategory(category1);
		projectRository.save(project1);
		
		Project project2 = new Project();
		project2.setName("SnowBoard");
		project2.setCategory(category1);
		projectRository.save(project2);
	}
}
