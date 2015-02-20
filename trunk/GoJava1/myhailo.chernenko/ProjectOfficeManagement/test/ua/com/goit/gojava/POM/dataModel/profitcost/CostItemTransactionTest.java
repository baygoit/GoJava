package ua.com.goit.gojava.POM.dataModel.profitcost;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItemTransaction;

public class CostItemTransactionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		CostItemTransaction costItemTransaction = new CostItemTransaction();
		assertNotNull(costItemTransaction);
		
	}


}
