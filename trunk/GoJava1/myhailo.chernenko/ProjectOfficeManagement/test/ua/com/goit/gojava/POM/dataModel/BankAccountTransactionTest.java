package ua.com.goit.gojava.POM.dataModel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTransactionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		CashFlowStatementEntry bankAccountTransaction = new CashFlowStatementEntry();
		assertNotNull(bankAccountTransaction);
		
	}


}
