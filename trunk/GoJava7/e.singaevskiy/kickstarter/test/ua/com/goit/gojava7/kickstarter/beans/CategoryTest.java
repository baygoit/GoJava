package ua.com.goit.gojava7.kickstarter.beans;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public class CategoryTest {
	
	Category testObject;
	
	@Before
	public void init() {
		testObject = new Category("test");
	}
	
	@Test
	public void setName() {
		System.out.println(testObject.getName());
		String name = "testName";
		testObject.setName(name);
		assertThat(testObject.getName(), is(name));
	}

	@Test
	public void equals() {
		System.out.println(testObject.getName());
		testObject.setName("");
		Category similarObject = new Category(testObject.getName());
		assertThat(testObject.equals(similarObject), is(true));
		assertThat(similarObject.equals(testObject), is(true));
		assertThat(testObject.hashCode(), is(similarObject.hashCode()));
	}
	
	@Test
	public void notEquals() {
		System.out.println(testObject.getName());
		Category similarObject = new Category("another");
		assertThat(testObject.equals(similarObject), is(false));
		assertThat(similarObject.equals(testObject), is(false));
		assertThat(testObject.hashCode(), not(similarObject.hashCode()));
		
		similarObject.setName(null);
		assertThat(similarObject.equals(testObject), is(false));
		assertThat(testObject.hashCode(), not(similarObject.hashCode()));
		
		assertThat(similarObject.equals(null), is(false));
		assertThat(similarObject.equals(new Object()), is(false));

	}
	
	@Test
	public void toStringTest() throws Exception {
		System.out.println(testObject.getName());
		assertThat(testObject.toString(), not(""));
	}
	
}
