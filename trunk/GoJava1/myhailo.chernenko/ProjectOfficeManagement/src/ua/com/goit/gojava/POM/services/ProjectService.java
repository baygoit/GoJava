package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.persistence.postgresDB.ProjectDAO;

public class ProjectService {
	
	ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		
		this.projectDAO = projectDAO;
		
	}
	
	public List<Project> retrieveAll() throws POMDataModelException {
		
		return projectDAO.retrieveAll();
		
	}

	public Project retrieveById(long id) throws POMDataModelException {

		return projectDAO.retrieveById(id);
		
	}

	public void delete(Project project) throws POMDataModelException {

		projectDAO.delete(project);
		
	}

	public void create(Project project) throws POMDataModelException {

		projectDAO.create(project);
		
	}

	public void update(Project project) throws POMDataModelException {

		projectDAO.update(project);
		
	}

}
