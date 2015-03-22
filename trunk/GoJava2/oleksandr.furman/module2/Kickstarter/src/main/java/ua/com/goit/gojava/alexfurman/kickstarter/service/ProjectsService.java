package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;

@Service
public class ProjectsService {

	@Autowired
	private ProjectDAO projectDAO;

	public List<Project> findByCategory(int categoryID) {
		return projectDAO.getProjectByCategoryId(categoryID);
	}
	
	public Project findOne(int id) {
		return projectDAO.getProjectById(id);
	}

	public void addPayment(Project project, Integer inputAmount) {
		if(inputAmount > 0){
		project.setPledged(project.getPledged() + inputAmount);
		projectDAO.update(project);
		}
	}
}
