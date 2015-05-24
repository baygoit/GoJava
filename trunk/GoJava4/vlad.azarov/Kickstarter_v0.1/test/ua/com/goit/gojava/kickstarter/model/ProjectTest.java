package ua.com.goit.gojava.kickstarter.model;

import org.junit.Test;

public class ProjectTest {

    Project project = new Project(null, null, 0, 0, 0, null, null, null, null, 0);
    Category category;
    
    @Test
    public void StupidGettersAndSettersTest() {
	project.setCategory(category);
	project.getBrief();
	project.getCategory();
	project.getDaysToGo();
	project.getDescription();
	project.getFAQ();
	project.getGoal();
	project.getLink();
	project.getName();
    } 
}
