package ua.com.goit.gojava7.kikstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.domain.Project;

public class MemoryProjectReader {

	public List<Project> readProjects() {
		List<Project> projects = new ArrayList<>();

		Project project1 = new Project(1, 1, "Project1", 35500, 12000);
		project1.setDescription("Project1 - Photography");
		project1.setUrl("https://www.kickstarter.com/project1");
		project1.setEndOfDays(10);

		Project project2 = new Project(2, 2, "Project2", 40000, 9500);
		project2.setDescription("Project2 - Movie");
		project2.setUrl("https://www.kickstarter.com/project2");

		project2.setEndOfDays(8);

		Project project3 = new Project(3, 3, "Project3", 21000, 1200);
		project3.setDescription("Project3 - Recording sound");
		project3.setUrl("https://www.kickstarter.com/project3");
		project3.setEndOfDays(15);

		projects.add(project1);
		projects.add(project2);
		projects.add(project3);

		return projects;
	}

}
