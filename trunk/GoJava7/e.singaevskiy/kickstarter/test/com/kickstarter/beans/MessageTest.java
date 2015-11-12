package com.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.sql.Date;

import org.junit.Test;

public class MessageTest {
	
	User user = new User("testUser");
	Message testObject = new Message(user, "testMessage");

	@Test
	public void testSetAuthor() {
		User user = new User("anotherUser");
		testObject.setAuthor(user);
		assertThat(testObject.getAuthor(), is(user));
	}

	@Test
	public void testSetText() {
		String text = "New text";
		testObject.setText(text);
		assertThat(testObject.getText(), is(text));
	}

	@Test
	public void testSetDate() {
		Date date = Date.valueOf("2015-11-11");
		testObject.setDate(date);
		assertThat(testObject.getDate(), is(date));
	}

	@Test
	public void testSetReplyTo() {
		Message similarObject = new Message(testObject.getAuthor(), "another text");
		testObject.setReplyTo(similarObject);
		assertThat(testObject.getReplyTo(), is(similarObject));
		testObject.setReplyTo(testObject);
		assertThat(testObject.getReplyTo(), not(testObject));
	}

	@Test
	public void testEquals() {
		Message similarObject = new Message(testObject.getAuthor(), testObject.getText());
		similarObject.setDate(testObject.getDate());
		assertThat(testObject.equals(similarObject), is(true));
		assertThat(similarObject.equals(testObject), is(true));
		assertThat(testObject.hashCode(), is(similarObject.hashCode()));
	}
	
	@Test
	public void testNotEquals() {
		Message similarObject = new Message(user, "anotherMessage");
		assertThat(testObject.equals(similarObject), is(false));
		assertThat(similarObject.equals(testObject), is(false));
		assertThat(testObject.hashCode(), not(similarObject.hashCode()));
		
		similarObject = new Message(testObject.getAuthor(), testObject.getText());
		similarObject.setDate(Date.valueOf("2015-11-11"));
		assertThat(testObject.equals(similarObject), is(false));
		assertThat(similarObject.equals(testObject), is(false));
		assertThat(testObject.hashCode(), not(similarObject.hashCode()));
		
		similarObject.setDate(null);
		assertThat(similarObject.equals(testObject), is(false));
		assertThat(testObject.hashCode(), not(similarObject.hashCode()));
		
		similarObject.setAuthor(null);
		assertThat(similarObject.equals(testObject), is(false));
		assertThat(testObject.hashCode(), not(similarObject.hashCode()));
		
		similarObject.setText(null);
		assertThat(similarObject.equals(testObject), is(false));
		assertThat(testObject.hashCode(), not(similarObject.hashCode()));
		
		assertThat(similarObject.equals(null), is(false));
		assertThat(similarObject.equals(new Object()), is(false));

	}

}
