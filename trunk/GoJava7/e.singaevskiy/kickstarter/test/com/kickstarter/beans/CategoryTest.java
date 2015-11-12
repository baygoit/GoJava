package com.kickstarter.beans;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class CategoryTest {

	Category testObject = new Category("test");
	
	@Test
	public void setName() {
		String name = "testName";
		testObject.setName(name);
		assertThat(testObject.getName(), is(name));
	}

	@Test
	public void equals() {
		Category similarObject = new Category(testObject.getName());
		assertThat(testObject.equals(similarObject), is(true));
		assertThat(similarObject.equals(testObject), is(true));
		assertThat(testObject.hashCode(), is(similarObject.hashCode()));
	}
	
	@Test
	public void notEquals() {
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
		assertThat(testObject.toString(), not(""));
	}
	
}
