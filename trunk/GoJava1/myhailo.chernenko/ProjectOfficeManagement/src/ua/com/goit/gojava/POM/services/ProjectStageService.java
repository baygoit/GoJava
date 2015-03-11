package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.persistence.postgresDB.ProjectStageDAO;

public class ProjectStageService {
	
	ProjectStageDAO projectStageDAO;

	public void setProjectStageDAO(ProjectStageDAO projectStageDAO) {
		
		this.projectStageDAO = projectStageDAO;
		
	}
	
	public List<ProjectStage> retrieveAll() throws POMDataModelException {
		
		return projectStageDAO.retrieveAll();
		
	}

	public ProjectStage retrieveById(long id) throws POMDataModelException {

		return projectStageDAO.retrieveById(id);
		
	}

	public void delete(ProjectStage projectStage) throws POMDataModelException {

		projectStageDAO.delete(projectStage);
		
	}

	public void create(ProjectStage projectStage) throws POMDataModelException {

		projectStageDAO.create(projectStage);
		
	}

	public void update(ProjectStage projectStage) throws POMDataModelException {

		projectStageDAO.update(projectStage);
		
	}

}
