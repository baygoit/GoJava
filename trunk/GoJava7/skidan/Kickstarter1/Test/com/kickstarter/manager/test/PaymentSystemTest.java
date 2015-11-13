package com.kickstarter.manager.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kickstarter.db.PayersDB;
import com.kickstarter.manager.PaymentSystem;
import com.kickstarter.manager.ProjectManager;

public class PaymentSystemTest {
	PayersDB pdb;
	PaymentSystem ps;
	ProjectManager pm;

	@Before
	public void start() {
		pm = new ProjectManager();
		pdb = new PayersDB();
		ps = new PaymentSystem();
	}

	@Test
	public void makePaymentTest() {
		int GainedSum = pm.getProject("sport", 1).getGainedSum();
		ps.acceptPayment(200, 1, "sport");
		int newGainedSum = pm.getProject("sport", 1).getGainedSum();
		assertEquals(newGainedSum, GainedSum + 200);
	}

	@Test
	public void addPayerListFillTest() {
		assertEquals(pdb.getPayersList().size(), 1);

	}

	@Test
	public void addPayerToDBTest() {
		ps.addPayer(12345, "Bill");
		assertEquals(pdb.getPayersList().get(12345).getName(), "Bill");

	}
}
