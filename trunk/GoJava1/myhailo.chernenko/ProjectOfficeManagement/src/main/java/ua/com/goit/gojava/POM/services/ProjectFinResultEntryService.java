package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.postgresDB.ProjectFinResultEntryDAO;

public class ProjectFinResultEntryService {
	
	ProjectFinResultEntryDAO projectFinResultEntryDAO;

	public void setProjectFinResultEntryDAO(ProjectFinResultEntryDAO projectFinResultEntryDAO) {
		
		this.projectFinResultEntryDAO = projectFinResultEntryDAO;
		
	}
	
	public List<ProjectFinResultEntry> retrieveAll() throws POMDataModelException {

		return projectFinResultEntryDAO.retrieveAll();
		
	}
	
	public ProjectFinResultEntry retrieveById(long id) throws POMDataModelException {

		return projectFinResultEntryDAO.retrieveById(id);
		
	}

	public void delete(ProjectFinResultEntry projectFinResultEntry) throws POMDataModelException {

		projectFinResultEntryDAO.delete(projectFinResultEntry);
		
	}

	public void create(ProjectFinResultEntry newEntry) throws POMDataModelException {

		projectFinResultEntryDAO.create(newEntry);
		
	}

	public void update(ProjectFinResultEntry projectFinResultEntry) throws POMDataModelException {

		projectFinResultEntryDAO.update(projectFinResultEntry);
		
	}

}
