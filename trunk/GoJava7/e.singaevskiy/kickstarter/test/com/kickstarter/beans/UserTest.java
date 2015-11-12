package com.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	
	User testObject = new User("testUser");

	@Test
	public void testEquals() {
		User similarObject = new User(testObject.getName());
		assertThat(testObject.equals(similarObject), is(true));
		assertThat(similarObject.equals(testObject), is(true));
		assertThat(testObject.hashCode(), is(similarObject.hashCode()));
	}
	
	@Test
	public void testNotEquals() {
		User similarObject = new User("anotherUser");
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
	public void testUserString() {
		String name = "testUser";
		User testObject = new User(name);
		assertThat(testObject.getName(), is(name));
	}

	@Test
	public void testUserStringString() {
		String name = "testUser";
		String pwd = "testPwd";
		User testObject = new User(name, pwd);
		assertThat(testObject.getName(), is(name));
		assertThat(testObject.getPassword(), is(pwd));
	}

	@Test
	public void testSetName() {
		String name = "testUser";
		testObject.setName(name);
		assertThat(testObject.getName(), is(name));
	}

	@Test
	public void testSetPassword() {
		String password = "testPwd";
		testObject.setPassword(password);
		assertThat(testObject.getPassword(), is(password));
	}

	@Test
	public void testToString() {
		assertThat(testObject.toString(), not(""));
	}

}
