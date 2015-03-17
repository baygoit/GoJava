package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Category;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.CategoryRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.ProjectRepository;

@Service
public class ProjectsService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private CategoryRepository blogRepository;

	public List<Project> findByCategory(int id) {
		Category category = blogRepository.findOne(id);
		return projectRepository.findByCategory(category);
	}
	
	public Project findOne(int id) {
		return projectRepository.findOne(id);
	}

	public void addPayment(Project project, Integer inputAmount) {
		if(inputAmount > 0){
		project.setPledged(project.getPledged() + inputAmount);
		projectRepository.save(project);
		}
	}
}
