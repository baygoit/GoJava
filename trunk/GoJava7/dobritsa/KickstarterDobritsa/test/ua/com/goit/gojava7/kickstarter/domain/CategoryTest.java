package ua.com.goit.gojava7.kickstarter.domain;

import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest extends  Assert{

	@Mock
	private PrintStream printSteam;
	
	Category category;
	Project project;
	List<Project> projects = new ArrayList<>();
	
	@Before
	public void setUp() {		
		System.setOut(printSteam);
		
		project = new Project("Name", "Description", 100, 10, 5);		
		projects.add(project);
		category = new Category("Category");
	}
	
	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);		
	}
	
	@Test
	public void testNewCategoryWithName() {
		Category category = new Category("Category");
		assertThat(category.getName(), is("Category"));
	}	
	
	@Test
	public void testToString() {
		Category category = new Category("CategoryName");
		System.out.println(category.toString());
		verify(printSteam).println("Category: CategoryName");
	}
	
	@Test
	public void testSetGetAll() {		
		category.setAll(projects);
		assertThat(category.getAll().size(), is(1));		
	}
	
	@Test
	public void testAddGet() {		
		category.setAll(projects);
		category.add(new Project("name", "description", 200, 20, 4));
		assertThat(category.size(), is (2));
		assertThat(category.get(1).getName(), is("name"));		
	}
	
	@Test
	public void testGetProjectIfEmpty() {
		Category category = new Category("Category");
		category.get(0);
		verify(printSteam).println("Nothing to show");
	}
	
}
