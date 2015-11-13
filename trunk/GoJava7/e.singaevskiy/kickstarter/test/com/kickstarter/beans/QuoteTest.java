package com.kickstarter.beans;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class QuoteTest {

	Quote testObject = new Quote("", "");
	
	@Test
	public void setAuthor() {
		String text = "testName";
		testObject.setAuthor(text);
		assertThat(testObject.getAuthor(), is(text));
	}
	
	@Test
	public void setText() {
		String text = "testName";
		testObject.setText(text);
		assertThat(testObject.getText(), is(text));
	}

	@Test
	public void equals() throws Exception {
		if (methodOverriden("equals")) {
			Quote similarObject = new Quote(testObject.getAuthor(), testObject.getText());
			assertThat(testObject.equals(similarObject), is(true));
			assertThat(similarObject.equals(testObject), is(true));
			assertThat(testObject.hashCode(), is(similarObject.hashCode()));
		} else {
			assertTrue(true);
		}
	}

	private boolean methodOverriden(String methodName){
		try {
			return Quote.class.getMethod(methodName).getDeclaringClass().equals(Quote.class);
		} catch (Exception e) {
			return false;
		}
	}
	
	@Test
	public void notEquals() throws Exception {
		if (methodOverriden("equals")) {
			Category similarObject = new Category("another");
			assertThat(testObject.equals(similarObject), is(false));
			assertThat(similarObject.equals(testObject), is(false));
			assertThat(testObject.hashCode(), not(similarObject.hashCode()));
			
			similarObject.setName(null);
			assertThat(similarObject.equals(testObject), is(false));
			assertThat(testObject.hashCode(), not(similarObject.hashCode()));
			
			assertThat(similarObject.equals(null), is(false));
			assertThat(similarObject.equals(new Object()), is(false));
		} else {
			assertTrue(true);
		}
	}
	
	@Test
	public void toStringTest() throws Exception {
		assertThat(testObject.toString(), not(""));
	}
	
}
