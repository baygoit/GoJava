package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class ProjectDAO extends AbstractDAO<Project> {
	
	private static final String CLASS_NAME = "Project"; 
	private static final Logger LOG = Logger.getLogger(ProjectDAO.class);
	
	public ProjectDAO() {
		super(Project.class);
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
	protected Project getNewObject() {
		return new Project();	
	}

}
