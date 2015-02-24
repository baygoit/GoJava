package ua.com.goit.gojava2.vova.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava2.vova.kickstarter.model.Projects;
import ua.com.goit.gojava2.vova.kickstarter.model.ProjectsFromDB;

public class TestProjectsClass {

	@Test
    public void should1_when(){
		Projects projects = new ProjectsFromDB();
		String s = projects.showProjectFull(3);
		assertEquals(s, "projectID = 3\n"		
				+ "project name: name3\n"
				+ "short description: short description3\n"
				+ "full description: full description3\n"
				+ "foto: foto3\n"
				+ "link: link3\n"
				+ "how much needed = 1000\n"
				+ "how much collected = 10\n"
				+ "how much remaining = 990\n"
				+ "faq = ");
    }
}
