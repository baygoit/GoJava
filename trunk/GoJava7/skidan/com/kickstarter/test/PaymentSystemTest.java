package com.kickstarter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

import com.kickstarter.PaymentSystem;

import com.kickstarter.storages.CategoryStorage;
import com.kickstarter.storages.PayersDataBase;

public class PaymentSystemTest {
	PayersDataBase pdb;
	PaymentSystem ps;

	@Before
	public void start() {
		pdb = new PayersDataBase();
		ps = new PaymentSystem();
	}

	@Test
	public void makePaymentTest() {
		int GainedSum = CategoryStorage.getCategoriesByNumber(1).getProjectList().get(1).getGainedSum();
		ps.acceptPayment(200, 1, 1);
		int newGainedSum = CategoryStorage.getCategoriesByNumber(1).getProjectList().get(1).getGainedSum();
		assertEquals(newGainedSum, GainedSum + 200);
	}

	@Test
	public void addPayerTest() {
		assertEquals(pdb.getPayersList().size(), 0);

	}
}
