package ua.com.goit.gojava.POM.dataModel.documents;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
//import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
//import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
//import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;

public class PaymentDocumentTest {

	private PaymentDocument paymentDoc;
	
	@Before
	public void setUp() throws Exception {
		
		paymentDoc = new PaymentDocument();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {

		assertNotNull(paymentDoc);
		
	}

	@Test
	public void testGenerateTransactions() {

		/*try{
			paymentDoc.generateTransactions();
		} catch(Exception e) {
		      fail("Error during generation transactions "+e.getMessage());
		}*/
		
		/*Project project = new Project();
		ProjectStage stage = project.createStage();
		CostItem costItem = new CostItem();
		BankAccount bankAccount = new BankAccount();
		
		paymentDoc.setCostItem(costItem);
		paymentDoc.setProject(project);
		paymentDoc.setProjectStage(stage);
		paymentDoc.setBankAccount(bankAccount);
		
		paymentDoc.generateTransactions();
		*/
		//assertEquals(costItem.getTransactions().size(), 1);
		//assertEquals(stage.getTransactions().size(), 1);
		//assertEquals(bankAccount.getTransactions().size(), 1);

	}

	@Test
	public void testDeleteTransactions() {

		/*try{
			paymentDoc.deleteTransactions();
		} catch(Exception e) {
		      fail("Error during deleting transactions "+e.getMessage());
		}
		
		Project project = new Project();
		ProjectStage stage = project.createStage();
		CostItem costItem = new CostItem();
		BankAccount bankAccount = new BankAccount();
		
		paymentDoc.setCostItem(costItem);
		paymentDoc.setProject(project);
		paymentDoc.setProjectStage(stage);
		paymentDoc.setBankAccount(bankAccount);
		
		paymentDoc.generateTransactions();
		
		//assertEquals(costItem.getTransactions().size(), 1);
		assertEquals(stage.getTransactions().size(), 1);
		//assertEquals(bankAccount.getTransactions().size(), 1);
		
		paymentDoc.deleteTransactions();
		
		//assertEquals(costItem.getTransactions().size(), 0);
		assertEquals(stage.getTransactions().size(), 0);
		//assertEquals(bankAccount.getTransactions().size(), 0);
		*/
	}

}
