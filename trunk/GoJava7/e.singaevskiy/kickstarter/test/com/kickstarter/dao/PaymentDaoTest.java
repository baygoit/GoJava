package com.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.kickstarter.beans.Payment;
import com.kickstarter.beans.User;
import com.kickstarter.dao.PaymentDAO;
import com.kickstarter.util.Utils;

public class PaymentDaoTest {

	private PaymentDAO dao = new PaymentDAO();
	private User user = new User("TestUser");
	
	{
		dao.add(new Payment(user, 123312L, 200L, Utils.dateFromString("25.04.2015")));
		dao.add(new Payment(user, 123312L, 150L, Utils.dateFromString("11.11.2015")));
		dao.add(new Payment(new User("AnotherUser"), 123312L, 150L, Utils.dateFromString("11.11.2015")));
	}
	
	@Test
	public void getAll() {
		List<Payment> list = dao.getAll();
		assertThat(list.isEmpty(), is(false));
	}
	
	@Test
	public void getByUser() {
		List<Payment> list = dao.getByUser(user);
		assertThat(list.size(), is(2));
		list.forEach(payment -> assertThat(payment.getUser(), is(user)));
	}

}
