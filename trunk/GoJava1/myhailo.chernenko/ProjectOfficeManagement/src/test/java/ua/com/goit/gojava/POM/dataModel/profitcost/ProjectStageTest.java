package ua.com.goit.gojava.POM.dataModel.profitcost;

import static org.junit.Assert.*;

//import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
//import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultTransaction;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;

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

		//List<ProjectFinResultTransaction> transactions = projectStage.getTransactions();
		//assertNotNull(transactions);
	
	}

	@Test
	public void testAddTransaction() {

		/*List<ProjectFinResultTransaction> transactions = projectStage.getTransactions();
		ProjectFinResultTransaction addedTransaction = projectStage.addTransaction();
		assertNotNull(addedTransaction);
		assertEquals(transactions.size(), 1);
		assertEquals(transactions, projectStage.getTransactions());
	*/
	}

	@Test
	public void testGetProfit() {

		/*ProjectFinResultTransaction addedTransaction = projectStage.addTransaction();
		addedTransaction.setSum(10);
		assertEquals(projectStage.getProfit(), 10);
		addedTransaction = projectStage.addTransaction();
		addedTransaction.setSum(20);
		assertEquals(projectStage.getProfit(), 30);
		ProjectFinResultTransaction added2Transaction = projectStage.addTransaction();
		added2Transaction.setSum(-30);
		assertEquals(projectStage.getProfit(), 0);
		*/
	}
	
	@Test
	public void testDeleteDocTransaction() {

		/*FinancialDocument financeDocument1 = new FinancialDocument() {};
		FinancialDocument financeDocument2 = new FinancialDocument() {};
		
		ProjectFinResultTransaction addedTransaction = projectStage.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = projectStage.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		
		assertEquals(projectStage.getTransactions().size(), 2);
		
		projectStage.deleteTransactionByDoc(financeDocument1);
		
		assertEquals(projectStage.getTransactions().size(), 0);
		
		addedTransaction = projectStage.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = projectStage.addTransaction();
		addedTransaction.setDoc(financeDocument1);
		addedTransaction = projectStage.addTransaction();
		addedTransaction.setDoc(financeDocument2);
		
		projectStage.deleteTransactionByDoc(financeDocument1);
		
		assertEquals(projectStage.getTransactions().size(), 1);
		
		for (ProjectFinResultTransaction trans: projectStage.getTransactions()) {
			assertEquals(trans.getDoc(), financeDocument2);
			assertNotEquals(trans.getDoc(), financeDocument1);
		}
		*/
	}

}
