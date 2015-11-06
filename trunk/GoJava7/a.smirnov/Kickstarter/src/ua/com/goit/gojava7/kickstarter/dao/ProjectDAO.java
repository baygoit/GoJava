package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectDAO extends CommonDAO<Project> {

	public ProjectDAO() {

		Project project1 = new Project();
		project1.setTitle("Testing 1");
		project1.setBriefDescription("XXXXXXXXXXXXXXXX");
		project1.setFullDescription("AAAAAAAAAAAAAAAAAAA");
		project1.setRequiredAmountOfMoney(10000);
		project1.setExpireProjectDate(07, 12, 2015);
		project1.setProjectCategory("Sports");

		Project project2 = new Project();
		project2.setTitle("Testing 2");
		project2.setBriefDescription("YYYYYYYYYYYYYYYY");
		project2.setFullDescription("AAAAAAAAAAAAAAAAAAA");
		project2.setRequiredAmountOfMoney(4000);
		project2.setExpireProjectDate(21, 11, 2016);
		project2.setProjectCategory("Sports");

		Project project3 = new Project();
		project3.setTitle("Testing 3");
		project3.setBriefDescription("ZZZZZZZZZZZZZZZZZ");
		project3.setFullDescription("LLLLLLLLLLLLLLLLLL");
		project3.setRequiredAmountOfMoney(79000);
		project3.setExpireProjectDate(9, 6, 2016);
		project3.setProjectCategory("Sports");

		dataSource.add(project1);
		dataSource.add(project2);
		dataSource.add(project3);
	}
}
