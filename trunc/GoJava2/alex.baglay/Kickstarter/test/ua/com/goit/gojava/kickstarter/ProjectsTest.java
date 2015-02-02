package ua.com.goit.gojava.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectsTest {

	@Test 
	public void shouldEmptyProjects_whenNoProjects() {
		// given 
		Projects list = new Projects();
		
		// when
		Project[] found = list.getProjects(new Category("name"));
		
		// then
		assertEquals(0, found.length);
	}
	
	@Test 
	public void shouldEmptyProjects_whenNoProjectsWithSameCategory() {
		// given 
		Category category = new Category("category");
		
		Projects list = new Projects();
		
		Project project1 = new Project("name", 100, 10, "video", "description");
		project1.setCategory(category);
		
		Project project2 = new Project("name2", 200, 20, "video2", "description2");
		project2.setCategory(category);
		
		list.add(project1);
		list.add(project2);
		
		// when
		Project[] found = list.getProjects(new Category("name"));
		
		// then
		assertEquals(0, found.length);
	}
	
	@Test 
	public void shouldFoundProjects_whenExistsProjectWithCategory() {
		// given 
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		
		Projects list = new Projects();
		
		Project project1 = new Project("name", 100, 10, "video", "description");
		project1.setCategory(category1); 
		
		Project project2 = new Project("name2", 200, 20, "video2", "description2");
		project2.setCategory(category2); 
		
		Project project3 = new Project("name3", 300, 30, "video3", "description3");
		project3.setCategory(category2); 
		
		list.add(project1);
		list.add(project2);
		list.add(project3);
		
		// when
		Project[] found = list.getProjects(category2);
		
		// then
		assertEquals(2, found.length);
		
		assertSame(project2, found[0]);
		assertSame(project3, found[1]);
	}
	
	@Test 
	public void shouldGetProject_whenExistsSomeProjects() {
		// given 
		Projects list = new Projects();
		
		Project project1 = new Project("name", 100, 10, "video", "description");	
		Project project2 = new Project("name2", 200, 20, "video2", "description2");
		
		list.add(project1);
		list.add(project2);
		
		// when then
		assertSame(project1, list.get(0));
		assertSame(project2, list.get(1));
	}
	
}
