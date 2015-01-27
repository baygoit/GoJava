package ua.com.goit.gojava.POM.dataModel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectFinResultTransactionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		ProjectFinResultTransaction  projectFinResultTransaction = new  ProjectFinResultTransaction();
		assertNotNull(projectFinResultTransaction);
		
	}

}
