package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sergiisavin.kickstarter.project.Project;

public class ProjectTest {

	Project project;
	
	@Before
	public void setup(){
		project = new Project("Jumping Frog Toy", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
	}
	
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
	
	@Test
	public void getStartedDate(){
		String startedDate = project.getStartedDate();
		assertEquals("01.05.2015", startedDate);
	}
	
	@Test
	public void getDescription(){
		String description = project.getDescription();
		assertEquals("DESCRIPTION", description);
	}
	
	@Test
	public void getProjectHistory(){
		String history = project.getProjectHistory();
		assertEquals("PROJECT HISTORY", history);
	}
	
	@Test
	public void getVideoURL(){
		String url = project.getVideoURL();
		assertEquals("VIDEO URL", url);
	}
	
	@Test
	public void questionsAnswers(){
		String questionsAnswers = project.getQuestionsAnswers();
		assertEquals("QUESTIONS AND ANSWERS", questionsAnswers);
	}

}
