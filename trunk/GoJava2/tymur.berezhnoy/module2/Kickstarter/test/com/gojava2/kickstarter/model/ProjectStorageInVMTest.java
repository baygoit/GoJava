package com.gojava2.kickstarter.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProjectStorageInVMTest {

	private ProjectStorageInVM projectStorage;
	
	@Before
	public void setUp() throws Exception {
		projectStorage = new ProjectStorageInVM();
	}

	@Test
	public void shouldEmptyCollection_whenNoProjects() {
		// given
		
		// when
		List<Project> projects = projectStorage.getSpecificProjects(new Category("Art"));
		int expectedSize = 0;
		
		// then
		assertEquals(expectedSize, projects.size());
	}
}