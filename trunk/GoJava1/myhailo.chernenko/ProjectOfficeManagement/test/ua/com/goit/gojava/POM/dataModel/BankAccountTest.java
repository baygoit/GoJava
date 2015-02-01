package ua.com.goit.gojava.POM.dataModel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

		List<BankAccountTransaction> transactions = bankAccount.getTransactions();
		assertNotNull(transactions);
		
	}

	@Test
	public void testAddTransaction() {

		List<BankAccountTransaction> transactions = bankAccount.getTransactions();
		BankAccountTransaction addedTransaction = bankAccount.addTransaction();
		assertNotNull(addedTransaction);
		assertEquals(transactions.size(), 1);
		assertEquals(transactions, bankAccount.getTransactions());
	
	}

	@Test
	public void testGetProfit() {

		BankAccountTransaction addedTransaction = bankAccount.addTransaction();
		addedTransaction.setSum(10);
		assertEquals(bankAccount.getTotal(), 10);
		BankAccountTransaction added2Transaction = bankAccount.addTransaction();
		added2Transaction.setSum(-10);
		assertEquals(bankAccount.getTotal(), 0);
		
	}
	
	@Test
	public void testDeleteDocTransaction() {

		FinanceDocument financeDocument1 = new FinanceDocument() {};
		FinanceDocument financeDocument2 = new FinanceDocument() {};
		
		BankAccountTransaction addedTransaction = bankAccount.addTransaction();
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
		
		for (BankAccountTransaction trans: bankAccount.getTransactions()) {
			assertEquals(trans.getDoc(), financeDocument2);
			assertNotEquals(trans.getDoc(), financeDocument1);
		}
		
	}

}
