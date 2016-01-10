package ua.com.goit.gojava7.kickstarter.models;

import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Matchers.contains;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest extends Assert {

	@Mock
	private PrintStream printSteam;

	private Category category;
	private Project project = new Project();
	List<Project> projects = new ArrayList<>();

	@Before
	public void setUp() {
		category = new Category();
		category.setName("CategoryName");
		category.setCategoryId(10L);

		projects.add(project);
		category.setProjects(projects);
		System.setOut(printSteam);		
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testNewCategoryWithName() {
		assertThat(category.getName(), is("CategoryName"));
	}
	
	@Test
	public void testGet() {
		assertThat(category.getCategoryId(), is(10L));
		assertThat(category.getProjects(), is(projects));
	}

	@Test
	public void testToString() {
		System.out.println(category.toString());
		verify(printSteam).println(contains("CategoryName"));
	}
}
