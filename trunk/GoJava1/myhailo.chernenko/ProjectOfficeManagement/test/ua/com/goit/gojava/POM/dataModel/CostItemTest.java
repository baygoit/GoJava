package ua.com.goit.gojava.POM.dataModel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CostItemTest {

	private CostItem costItem;
	
	@Before
	public void setUp() throws Exception {
		
		costItem = new CostItem();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		assertNotNull(costItem);
		
	}

	@Test
	public void testGetTransactions() {

		List<CostItemTransaction> transactions = costItem.getTransactions();
		assertNotNull(transactions);
		
	}

	@Test
	public void testAddTransaction() {

		List<CostItemTransaction> transactions = costItem.getTransactions();
		CostItemTransaction addedTransaction = costItem.addTransaction();
		assertNotNull(addedTransaction);
		assertEquals(transactions.size(), 1);
		assertEquals(transactions, costItem.getTransactions());
	
	}

	@Test
	public void testGetProfit() {

		CostItemTransaction addedTransaction = costItem.addTransaction();
		addedTransaction.setSum(10);
		assertEquals(costItem.getProfit(), 10);
		CostItemTransaction added2Transaction = costItem.addTransaction();
		added2Transaction.setSum(-10);
		assertEquals(costItem.getProfit(), 0);
		
	}

}
