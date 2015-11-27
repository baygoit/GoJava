package ua.com.goit.gojava7.kikstarter;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Project;

public class CategoryTest {

	private Project projectTest;
	private Category categoryTest;

	@Before
	public void setObjectCatecoryTest() {
		projectTest = new Project("Project Test", 2000, 500, 4);
		categoryTest = new Category("Test name");
		categoryTest.setProject(projectTest);
		categoryTest.setNameCategory("Test name");
	}

	@Test
	public void test() {
		assertThat(categoryTest.getNameCategory(), is("Test name"));
		assertThat(categoryTest.getProject(0), is(projectTest));
		assertThat(categoryTest.getAllProjectsInThisCategory().get(0), is(projectTest));
	}

}
