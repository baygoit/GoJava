package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void test() {
		Project project = new Project("Jumping Frog Toy", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		assertNotNull(project);
	}
	
	@Test 
	public void projectToString(){
		Project project = new Project("Jumping Frog Toy", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		System.out.println(project.toString());
	}

}
