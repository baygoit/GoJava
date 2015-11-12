package com.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PaymentTest {
	
	Payment testObject = new Payment(new User("testUser"), 123, 456, new Date());

	@Test
	public void testGetCardId() {
		long id = 1000;
		testObject.setCardId(id);
		assertThat(testObject.getCardId(), is(id));
	}

	@Test
	public void testGetSum() {
		long sum = 1000;
		testObject.setSum(sum);
		assertThat(testObject.getSum(), is(sum));
	}

	@Test
	public void testGetUser() {
		User user = new User("anotherUser");
		testObject.setUser(user);
		assertThat(testObject.getUser(), is(user));
	}

	@Test
	public void testGetDate() {
		Date date = java.sql.Date.valueOf("2015-10-10");
		testObject.setDate(date);;
		assertThat(testObject.getDate(), is(date));
	}

}
