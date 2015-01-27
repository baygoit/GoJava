package ua.com.goit.gojava.POM.dataModel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectStageTest {

	private ProjectStage projectStage;
	
	@Before
	public void setUp() throws Exception {
		
		projectStage = new ProjectStage();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		assertNotNull(projectStage);
		
	}

	@Test
	public void testGetTransactions() {

		List<ProjectFinResultTransaction> transactions = projectStage.getTransactions();
		assertNotNull(transactions);
	
	}

	@Test
	public void testAddTransaction() {

		List<ProjectFinResultTransaction> transactions = projectStage.getTransactions();
		ProjectFinResultTransaction addedTransaction = projectStage.addTransaction();
		assertNotNull(addedTransaction);
		assertEquals(transactions.size(), 1);
		assertEquals(transactions, projectStage.getTransactions());
	
	}

	@Test
	public void testGetProfit() {

		ProjectFinResultTransaction addedTransaction = projectStage.addTransaction();
		addedTransaction.setSum(10);
		assertEquals(projectStage.getProfit(), 10);
		ProjectFinResultTransaction added2Transaction = projectStage.addTransaction();
		added2Transaction.setSum(-10);
		assertEquals(projectStage.getProfit(), 0);
		
	}

}
