package ua.com.goit.gojava7.kickstarter.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.PaymentSystem;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.PayersDataBase;


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
	public void addPayerListFillTest() {
		assertEquals(pdb.getPayersList().size(), 1);

	}
	@Test
	public void addPayerToDBTest() {
		ps.addPayer(12345,"Bill");
		assertEquals(pdb.getPayersList().get(12345).getName(), "Bill" );

	}
}
