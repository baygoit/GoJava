package ua.com.goit.gojava7.kickstarter.storage;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectsStorage extends AbstractStorage<Project> {

	public ProjectsStorage() {
		Project project1 = new Project();
		project1.setTitle("Testing 1");
		project1.setBriefDescription("XXXXXXXXXXXXXXXX");
		project1.setFullDescription("AAAAAAAAAAAAAAAAAAA");
		project1.setRequiredAmountOfMoney(10000);
		project1.setFinalDateForFundraising(07, 12, 2015);
		project1.setProjectCategory("Sports");
		
		Project project2 = new Project();
		project2.setTitle("Testing 2");
		project2.setBriefDescription("YYYYYYYYYYYYYYYY");
		project2.setFullDescription("AAAAAAAAAAAAAAAAAAA");
		project2.setRequiredAmountOfMoney(4000);
		project2.setFinalDateForFundraising(21, 11, 2016);
		project2.setProjectCategory("Art");
		
		dataSource.add(project1);
		dataSource.add(project2);
	}
}
