package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;

import com.sergiisavin.kickstarter.project.Project;
import com.sergiisavin.kickstarter.project.container.file.ProjectsContainerFile;

public class ProjectsContainerFileTest{

	ProjectsContainerFile projects;
	
	@Before
	public void test() {
		projects = new ProjectsContainerFile();
	}

	@Test(expected = OperationNotSupportedException.class)
	public void addThrowsException() throws OperationNotSupportedException{
		projects.add(new Project("Jumping Frog Toy", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS"));
	}
	
	@Test
	public void tenLinesPerProjectInFile(){
		int size = projects.getSize();
		assertEquals(1, size);
	}
}
