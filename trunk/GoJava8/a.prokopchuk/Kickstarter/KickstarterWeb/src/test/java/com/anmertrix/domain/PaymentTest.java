package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PaymentTest {
	
	Payment payment = new Payment();
	
	@Test
	public void setGetIdTest() {
		payment.setId(24);
		assertThat(payment.getId(), is(24));
	}
	
	@Test
	public void setGetProjectIdTest() {
		payment.setProjectId(2);
		assertThat(payment.getProjectId(), is(2));
	}
	
	@Test
	public void setGetCardNumberTest() {
		payment.setCardNumber("test2");
		assertThat(payment.getCardNumber(), is("test2"));
	}
	
	@Test
	public void setGetCardholderNameTest() {
		payment.setCardholderName("test2");
		assertThat(payment.getCardholderName(), is("test2"));
	}
	
	@Test
	public void setGetAmountTest() {
		payment.setAmount(30);
		assertThat(payment.getAmount(), is(30));
	}

}
