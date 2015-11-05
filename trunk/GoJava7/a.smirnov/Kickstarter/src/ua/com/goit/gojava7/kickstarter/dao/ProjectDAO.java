package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectDAO extends CommonDAO<Project> {

	public ProjectDAO() {
		Project project1 = new Project();
		project1.setTitle("The Flying Animator - A documentary film");
		project1.setBriefDescription("Maverick animator-director Gerald Potterton loves airplanes but hates to fly. "
				+ "Help fund the first ever documentary on the man who drew too much.");
		project1.setRequiredAmountOfMoney(10000);
		project1.setFinalDateForFundraising(07, 12, 2015);
		dataSource.add(project1);
	}
}
