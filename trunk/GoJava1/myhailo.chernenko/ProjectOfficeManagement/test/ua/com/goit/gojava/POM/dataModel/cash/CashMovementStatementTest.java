package ua.com.goit.gojava.POM.dataModel.cash;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CashMovementStatementTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		CashMovementStatement cashMovementStatement = new CashMovementStatement();
		assertNotNull(cashMovementStatement);
		
	}
	
	@Test
	public void testGetInstanse() {

		CashMovementStatement cashMovementStatement = new CashMovementStatement();
		assertNotNull(cashMovementStatement.getNewInstanse());
		assertNotEquals(cashMovementStatement.getNewInstanse(), cashMovementStatement);
		
	}


}
