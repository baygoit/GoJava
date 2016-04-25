package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PaymentTest {
	
	Payment payment = new Payment();
	
	@Test
	public void setGetIdTest() {
		payment.setId(24L);
		assertThat(payment.getId(), is(24L));
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
