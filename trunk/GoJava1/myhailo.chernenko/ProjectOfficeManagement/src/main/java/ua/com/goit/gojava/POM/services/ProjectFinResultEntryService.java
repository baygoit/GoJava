package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.ProjectFinResultEntryDAO;

public class ProjectFinResultEntryService {
	
	private static final String CLASS_NAME = "Project FinResult Entry"; 
	private static final Logger LOG = Logger.getLogger(ExchangeRateService.class);
	ProjectFinResultEntryDAO projectFinResultEntryDAO;

	public void setProjectFinResultEntryDAO(ProjectFinResultEntryDAO projectFinResultEntryDAO) {
		
		this.projectFinResultEntryDAO = projectFinResultEntryDAO;
		
	}
	
	public List<ProjectFinResultEntry> retrieveAll() throws POMServicesException {

		try {
			return projectFinResultEntryDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	
	public ProjectFinResultEntry retrieveById(long id) throws POMServicesException {

		try {
			return projectFinResultEntryDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve "+CLASS_NAME+" by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve "+CLASS_NAME+" by ID",e);
		}
		
	}

	public void delete(ProjectFinResultEntry projectFinResultEntry) throws POMServicesException {

		try {
			projectFinResultEntryDAO.delete(projectFinResultEntry);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not delete "+CLASS_NAME+"",e);
		}
		
	}

	public void create(ProjectFinResultEntry newEntry) throws POMServicesException {

		try {
			projectFinResultEntryDAO.create(newEntry);
		} catch (POMPersistenceException e) {
			LOG.error("Could not create "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not create "+CLASS_NAME+"",e);
		}
		
	}

	public void update(ProjectFinResultEntry projectFinResultEntry) throws POMServicesException {

		try {
			projectFinResultEntryDAO.update(projectFinResultEntry);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not update "+CLASS_NAME+"",e);
		}
		
	}
	
	public void deleteAllByDoc(FinancialDocument doc) throws POMServicesException {

		try {
			projectFinResultEntryDAO.deleteAllByDoc(doc);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete all by Doc: "+e.getMessage(), e);
			throw new POMServicesException("Could not delete all by Doc",e);
		}
		
	}

}
