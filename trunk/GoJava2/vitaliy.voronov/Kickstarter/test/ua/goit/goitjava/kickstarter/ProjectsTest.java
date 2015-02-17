package ua.goit.goitjava.kickstarter;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ProjectsTest {

	@Test
	public void QuoteTest() {
		Projects s = new Projects();
		assertEquals(0, s.getSize());
	}
	
	@Test
	public void arrayTest(){
		Projects s = new Projects();
		Category cat1 = new Category("Education");
		ArrayList <Project> projects = s.getProjectsByCategory(cat1);
		
		for(Project proj: projects)
		{
			assertEquals(cat1.getName(), proj.getCategory());
		}
	}

}
