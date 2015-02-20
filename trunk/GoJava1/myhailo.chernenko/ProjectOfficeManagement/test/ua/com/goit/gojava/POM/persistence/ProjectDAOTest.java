package ua.com.goit.gojava.POM.persistence;


import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.persistence.abstraction.GenericDAOTest;

public class ProjectDAOTest extends GenericDAOTest<Project> {

	public ProjectDAOTest() {
		super(Project.class);
	}
	
}
