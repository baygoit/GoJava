package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
	private Project progect;

	@Before 
	public void setUp(){
		progect = new Project("Super project", 1);
	}
	
	@Test
	public void testGetName() {
		assertThat(progect.getName(), is("Super project"));
	}

}