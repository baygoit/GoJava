package goit.nz.kickstartermvc.test.dao;

import static org.junit.Assert.*;
import goit.nz.kickstartermvc.dao.Project;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void whenDescriptionIsEmptyThenReturnThreePoints() {
		Project testProject = new Project("test");
		String expected = "...";
		String actual = testProject.getDescription();
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenEventsIsEmptyThenReturnThreePoints() {
		Project testProject = new Project("test");
		String expected = "...";
		String actual = testProject.getEvents();
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenLinkIsEmptyThenReturnFiller() {
		Project testProject = new Project("test");
		String expected = "-/-";
		String actual = testProject.getLink();
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFAQIsEmptyThenReturnNA() {
		Project testProject = new Project("test");
		String expected = "N/A";
		String actual = testProject.getFAQ();
		assertEquals(expected, actual);
	}

}
