package ua.com.goit.gojava.POM.dataModel.cash;

import static org.junit.Assert.*;

//import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;

public class BankAccountTest {

	private BankAccount bankAccount;
	
	@Before
	public void setUp() throws Exception {
		
		bankAccount = new BankAccount();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		assertNotNull(bankAccount);
		
	}

	@Test
	public void testGetTransactions() {

		/*List<CashFlowStatementEntry> transactions = bankAccount.getTransactions();
		assertNotNull(transactions);
		*/
	}

	@Test
	public void testAddTransaction() {

		/*List<CashFlowStatementEntry> transactions = bankAccount.getTransactions();
		CashFlowStatementEntry addedTransaction = bankAccount.addTransaction();
		assertNotNull(addedTransaction);
		assertEquals(transactions.size(), 1);
		assertEquals(transactions, bankAccount.getTransactions());
		*/
	}

	@Test
	public void testGetProfit() {

		/*CashFlowStatementEntry addedTransaction = bankAccount.addTransaction();
		addedTransaction.setSum(10);
		assertEquals(bankAccount.getTotal(), 10);
		CashFlowStatementEntry added2Transaction = bankAccount.addTransaction();
		added2Transaction.setSum(-10);
		assertEquals(bankAccount.getTotal(), 0);
		*/
	}
	
	@Test
	public void testDeleteDocTransaction() {

		/*FinanceDocument financeDocument1 = new FinanceDocument() {};
		FinanceDocument financeDocument2 = new FinanceDocument() {};
		
		CashFlowStatementEntry addedTransaction = bankAccount.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = bankAccount.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		
		assertEquals(bankAccount.getTransactions().size(), 2);
		
		bankAccount.deleteDocTransaction(financeDocument1);
		
		assertEquals(bankAccount.getTransactions().size(), 0);
		
		addedTransaction = bankAccount.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = bankAccount.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = bankAccount.addTransaction();
		addedTransaction.setDoc(financeDocument2);
		
		bankAccount.deleteDocTransaction(financeDocument1);
		
		assertEquals(bankAccount.getTransactions().size(), 1);
		
		for (CashFlowStatementEntry trans: bankAccount.getTransactions()) {
			assertEquals(trans.getDoc(), financeDocument2);
			assertNotEquals(trans.getDoc(), financeDocument1);
		}
		*/
		
	}

}
