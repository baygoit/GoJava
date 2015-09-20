package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Category;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.User;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.CategoryRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.ProjectRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.UserRepository;

@Service
public class ProjectsService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;
	
	public List<Project> findByCategory(int id) {
		Category category = categoryRepository.findOne(id);
		return projectRepository.findByCategory(category);
	}
	
	public List<Project> findByUser(int id) {
		User user = userRepository.findOne(id);
		return projectRepository.findByUser(user);
	}
	
	public Project findOne(int id) {
		Project project = projectRepository.findOne(id);
		return project;
	}

	public void addPayment(Project project, Integer inputAmount) {
		if(inputAmount > 0){
		project.setPledged(project.getPledged() + inputAmount);
		projectRepository.save(project);
		}
	}
	
	public void save(Project project, String name) {
		User user = userRepository.findByName(name);
		project.setUser(user);
		projectRepository.save(project);
	}
	
	@PreAuthorize("#project.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("project") Project project) {
		projectRepository.delete(project);
	}
}
