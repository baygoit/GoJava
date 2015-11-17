package com.kickstarter.manager.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import com.kickstarter.db.PayersDB;
import com.kickstarter.manager.PaymentSystem;
import com.kickstarter.manager.ProjectManager;
import com.kickstarter.util.UserConsoleInputReader;

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

//	@Test
//	public void acceptPayerNameTest() {
//		UserConsoleInputReader userInp = mock(UserConsoleInputReader.class);
//     	when(userInp.readStringInput()).thenReturn("payer");
//		assertEquals(ps.acceptPayerName(), "payer");
//
//	}

//	 @Test
//	 public void makePaymenttTest() {
//		 int sum = pm.getProject("it", 1).getGainedSum();
//		 PaymentSystem ps = new PaymentSystem(); 
//		 PaymentSystem spy  = spy(ps);
//		 doReturn("payer").when(spy).acceptPayerName();
//		 doReturn(1000).when(spy).acceptPayercardId();
//		 doReturn(1000).when(spy).acceptPayment();
//         spy.makePayment(1, 1, "it");
//	     int sumNew = pm.getProject("it", 1).getGainedSum();
//	     assertEquals(sum + 1000, sumNew);
//	
//	 }
}
