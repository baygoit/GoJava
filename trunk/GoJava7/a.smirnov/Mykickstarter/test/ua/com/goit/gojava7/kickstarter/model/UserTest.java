package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class UserTest {
	CreditCard card = new CreditCard(123457689);
	User user = new User("Name", 12345, card);
	
	@Test
	public void testUser() {
		assertThat(user.getName(), is("Name"));
		assertThat(user.getPassword(), is(12345));
	}
	
	@Test
	public void testSetPassword() {
		user.setPassword(123);
		assertThat(user.getPassword(), is(123));
	}
	
	@Test
	public void testSetName() {
		user.setName("Amigo");
		assertThat(user.getName(), is("Amigo"));
	}
}
