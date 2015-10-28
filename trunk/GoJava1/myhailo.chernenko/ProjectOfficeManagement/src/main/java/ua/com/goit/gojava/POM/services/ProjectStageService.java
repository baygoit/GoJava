package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.ProjectStageDAO;

public class ProjectStageService {
	
	private static final Logger LOG = Logger.getLogger(ProjectStageService.class);
	ProjectStageDAO projectStageDAO;

	public void setProjectStageDAO(ProjectStageDAO projectStageDAO) {
		
		this.projectStageDAO = projectStageDAO;
		
	}
	
	public List<ProjectStage> retrieveAll() throws POMServicesException {
		
		try {
			return projectStageDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all ProjectStages: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all ProjectStages",e);
		}
		
	}
	
	public List<ProjectStage> retrieveAll(Paginator paginator) throws POMServicesException {
		
		try {
			return projectStageDAO.retrieveAll(paginator);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all ProjectStages: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all ProjectStages",e);
		}
	}

	public ProjectStage retrieveById(long id) throws POMServicesException {

		try {
			return projectStageDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve ProjectStage by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve ProjectStage by ID",e);
		}
	}

	public void delete(ProjectStage projectStage) throws POMServicesException {

		try {
			projectStageDAO.delete(projectStage);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete ProjectStage: "+e.getMessage(), e);
			throw new POMServicesException("Could not delete ProjectStage",e);
		}
	}

	public void create(ProjectStage projectStage) throws POMServicesException {

		try {
			projectStageDAO.create(projectStage);
		} catch (POMPersistenceException e) {
			LOG.error("Could not create ProjectStage: "+e.getMessage(), e);
			throw new POMServicesException("Could not create ProjectStage",e);
		}
	}

	public void update(ProjectStage projectStage) throws POMServicesException {

		try {
			projectStageDAO.update(projectStage);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update ProjectStage: "+e.getMessage(), e);
			throw new POMServicesException("Could not update ProjectStage",e);
		}
	}

}
