package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectReader;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class MemoryProjectReader implements ProjectReader {

	@Override
	public List<Project> readProjects() {	
		List<Project> projects = new ArrayList<>();
		
		Project progect1 = new Project("Super project", 1);
		progect1.setCategoryId(1);
		progect1.setDaysToGo(14);
		progect1.setGoal(100);
		progect1.setOwner("owner");
		progect1.setDescription("descr");
		progect1.setLinkVideo("link");
		
		projects.add(progect1);
		
		Project progect2 = new Project("Second project", 2);
		progect2.setCategoryId(1);
		
		projects.add(progect2);
		
		return projects;
	}

}
