package ua.com.goit.gojava7.kickstarter.model;

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

	@Test
	public void testEqualsIfAllEqualReturnTrue() {
		Category category1 = new Category();
		category1.setCategoryId(10L);
		category1.setName("Dance");

		Category category2 = new Category();
		category1.setCategoryId(10L);
		category2.setName("Dance");

		assertTrue(category1.equals(category2));
	}

	@Test
	public void testEqualsIfAllUnequalsReturnFalse() {
		Category category1 = new Category();
		category1.setCategoryId(10L);
		category1.setName("Dance");

		Category category2 = new Category();
		category2.setCategoryId(20L);
		category2.setName("Movie");

		assertFalse(category1.equals(category2));
	}

	@Test
	public void testEqualsIfIdUnequalsReturnFalse() {
		Category category1 = new Category();
		category1.setCategoryId(10L);
		category1.setName("Dance");

		Category category2 = new Category();
		category2.setCategoryId(20L);
		category2.setName("Dance");

		assertFalse(category1.equals(category2));
	}

	@Test
	public void testEqualsIfNameUnequalsReturnFalse() {
		Category category1 = new Category();
		category1.setCategoryId(10L);
		category1.setName("Dance");

		Category category2 = new Category();
		category2.setCategoryId(10L);
		category2.setName("Movie");

		assertFalse(category1.equals(category2));
	}

	@Test
	public void testEqualsIfEmptyReturnTrue() {
		Category category1 = new Category();
		Category category2 = new Category();

		assertTrue(category1.equals(category2));
	}
}
