package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentTest {

	Payment payment = new Payment();
	@Before
	public void init() {
		payment.setAmount(100);
		payment.setId(1);
		payment.setProjectId(1);
	}
	
	@Test
	public void testGetAmount() {
		assertThat(payment.getAmount() , is(100));
	}


	@Test
	public void testGetId() {
		assertThat(payment.getId() , is(1));
	}


	@Test
	public void testGetProjectId() {
		assertThat(payment.getProjectId() , is(1));
	}

}
