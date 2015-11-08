package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.ProjectDAO;

public class ProjectService {
	
	private static final Logger LOG = Logger.getLogger(ProjectService.class);
	ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		
		this.projectDAO = projectDAO;
		
	}
	
	public List<Project> retrieveAll() throws POMServicesException {
		
		try {
			return projectDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all Projects: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all Projects",e);
		}
		
	}
	
	public List<Project> retrieveAll(Paginator paginator) throws POMServicesException {
		
		try {
			return projectDAO.retrieveAll(paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all Projects: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all Projects",e);
		}
	}

	public Project retrieveById(long id) throws POMServicesException {

		try {
			return projectDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve Project by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve Project by ID",e);
		}
	}

	public void delete(Project project) throws POMServicesException {

		try {
			projectDAO.delete(project);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete Project: "+e.getMessage(), e);
			throw new POMServicesException("Could not delete Project",e);
		}
	}

	public void create(Project project) throws POMServicesException {

		try {
			projectDAO.create(project);
		} catch (POMPersistenceException e) {
			LOG.error("Could not create Project: "+e.getMessage(), e);
			throw new POMServicesException("Could not create Project",e);
		}
	}

	public void update(Project project) throws POMServicesException {

		try {
			projectDAO.update(project);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update Project: "+e.getMessage(), e);
			throw new POMServicesException("Could not update Project",e);
		}
	}

}
