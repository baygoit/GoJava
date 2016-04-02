package com.anmertrix.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.anmertrix.domain.Project;

public class ProjectTest {

	@Test
	public void setGetIdTest() {
		Project project = new Project();
		project.setId(4);
		assertTrue(4 == project.getId());
	}
	
	@Test
	public void setGetNameTest() {
		Project project = new Project();
		project.setName("test");
		assertTrue("test" == project.getName());
	}

	@Test
	public void setGetDescriptionTest() {
		Project project = new Project();
		project.setDescription("description-test");
		assertTrue("description-test" == project.getDescription());
	}

	@Test
	public void setGetHistoryTest() {
		Project project = new Project();
		project.setHistory("history-test");
		assertTrue("history-test" == project.getHistory());
	}

	@Test
	public void setGetRequiredBudgetTest() {
		Project project = new Project();
		project.setRequiredBudget(10);
		assertTrue(10 == project.getRequiredBudget());
	}

	@Test
	public void setGetCollectedSumTest() {
		Project project = new Project();
		project.setGatheredBudget(100);
		assertTrue(100 == project.getGatheredBudget());
	}

	@Test
	public void setGetDaysLeftTest() {
		Project project = new Project();
		project.setDaysLeft(200);
		assertTrue(200 == project.getDaysLeft());
	}

	@Test
	public void setGetUrlTest() {
		Project project = new Project();
		project.setUrl("qqq");
		assertEquals("qqq", project.getUrl());
	}

	@Test
	public void setGetQuestionAnswerTest() {
		Project project = new Project();
		project.setQuestion("qqq");
		assertEquals("qqq\n", project.getQuestionAnswer());
	}

	@Test
	public void setProjectDataTest() {
		Project project = new Project();
		project.setProjectData(1, "test1", "test2", 1, 2, 3, "test3");
		assertEquals(1, project.getId());
		assertEquals("test1", project.getName());
		assertEquals("test2", project.getDescription());
		assertEquals(1, project.getRequiredBudget());
		assertEquals(2, project.getGatheredBudget());
		assertEquals(3, project.getDaysLeft());
		assertEquals("test3", project.getHistory());
	}

}
