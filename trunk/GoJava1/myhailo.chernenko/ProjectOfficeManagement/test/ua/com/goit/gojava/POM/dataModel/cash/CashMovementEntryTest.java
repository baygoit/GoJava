package ua.com.goit.gojava.POM.dataModel.cash;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CashMovementEntryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		CashMovementEntry cashMovementEntry = new CashMovementEntry();
		assertNotNull(cashMovementEntry);
		
	}

}
