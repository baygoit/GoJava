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

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest extends Assert {

	@Mock
	private PrintStream printSteam;

	Category category;

	@Before
	public void setUp() {
		category = new Category();
		category.setName("CategoryName");
		category.setId(10);
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
		assertThat(category.getId(), is(10));
	}

	@Test
	public void testToString() {
		System.out.println(category.toString());
		verify(printSteam).println("CategoryName");
	}
}
