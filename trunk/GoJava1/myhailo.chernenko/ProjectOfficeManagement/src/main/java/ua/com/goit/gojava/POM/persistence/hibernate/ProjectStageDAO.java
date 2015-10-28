package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class ProjectStageDAO extends AbstractDAO<ProjectStage> {
	
	private static final String CLASS_NAME = "Project Stage"; 
	private static final Logger LOG = Logger.getLogger(ProjectStageDAO.class);
	
	public ProjectStageDAO() {
		super(ProjectStage.class);
	}

	@Override
	protected String getClassName() {		
		return CLASS_NAME;
	}

	@Override
	protected Logger getLog() {	
		return LOG;	
	}

	@Override
	protected ProjectStage getNewObject() {
		return new ProjectStage();	
	}

}
