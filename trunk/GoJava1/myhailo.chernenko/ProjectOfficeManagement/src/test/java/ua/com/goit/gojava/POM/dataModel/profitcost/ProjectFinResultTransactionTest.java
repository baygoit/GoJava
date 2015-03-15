package ua.com.goit.gojava.POM.dataModel.profitcost;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;

public class ProjectFinResultTransactionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		ProjectFinResultEntry  projectFinResultTransaction = new  ProjectFinResultEntry();
		assertNotNull(projectFinResultTransaction);
		
	}

}
