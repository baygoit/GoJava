package ua.com.goit.gojava.POM.dataModel.profitcost;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
//import ua.com.goit.gojava.POM.dataModel.profitcost.CostItemTransaction;

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

		/*List<CostItemTransaction> transactions = costItem.getTransactions();
		assertNotNull(transactions);
		*/
	}

	@Test
	public void testAddTransaction() {

		/*List<CostItemTransaction> transactions = costItem.getTransactions();
		CostItemTransaction addedTransaction = costItem.addTransaction();
		assertNotNull(addedTransaction);
		assertEquals(transactions.size(), 1);
		assertEquals(transactions, costItem.getTransactions());
	*/
	}

	@Test
	public void testGetProfit() {

		/*CostItemTransaction addedTransaction = costItem.addTransaction();
		addedTransaction.setSum(10);
		assertEquals(costItem.getProfit(), 10);
		CostItemTransaction added2Transaction = costItem.addTransaction();
		added2Transaction.setSum(-10);
		assertEquals(costItem.getProfit(), 0);
		*/
	}
	
	@Test
	public void testDeleteDocTransaction() {

		/*FinancialDocument financeDocument1 = new FinancialDocument() {};
		FinancialDocument financeDocument2 = new FinancialDocument() {};
		
		CostItemTransaction addedTransaction = costItem.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = costItem.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		
		assertEquals(costItem.getTransactions().size(), 2);
		
		costItem.deleteDocTransaction(financeDocument1);
		
		assertEquals(costItem.getTransactions().size(), 0);
		
		addedTransaction = costItem.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = costItem.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = costItem.addTransaction();
		addedTransaction.setDoc(financeDocument2);
		
		costItem.deleteDocTransaction(financeDocument1);
		
		assertEquals(costItem.getTransactions().size(), 1);
		
		for (CostItemTransaction trans: costItem.getTransactions()) {
			assertEquals(trans.getDoc(), financeDocument2);
			assertNotEquals(trans.getDoc(), financeDocument1);
		}*/
		
	}

}
