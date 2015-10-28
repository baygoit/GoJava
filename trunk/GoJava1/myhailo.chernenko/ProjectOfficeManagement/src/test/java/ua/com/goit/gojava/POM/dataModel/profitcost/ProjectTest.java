package ua.com.goit.gojava.POM.dataModel.profitcost;

import static org.junit.Assert.*;

//import java.util.List;

import org.junit.Before;
import org.junit.Test;

//import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
//import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultTransaction;
//import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;

public class ProjectTest {

	private Project project;
	
	@Before
	public void setUp() throws Exception {
		
		project = new Project();
		
	}

	@Test
	public void testCreation() {
		
		assertNotNull(project);
		
	}
	
	@Test
	public void testGetStages() {

		/*List<ProjectStage> stages = project.getStages();
		assertNotNull(stages);
	*/
	}
	
	@Test
	public void testCreateStage() {
		
		/*List<ProjectStage> stages = project.getStages();
		ProjectStage ps = project.createStage();
		assertNotNull(ps);
		assertEquals(project.getStages().size(),1);
		assertEquals(stages, project.getStages());
		*/
	}
	
	@Test
	public void testAddTransaction() {

		/*ProjectStage ps = project.createStage();
		ProjectFinResultTransaction addedTransaction = project.addTransaction(ps);
		assertNotNull(addedTransaction);
		assertEquals(ps.getTransactions().size(),1);
		*/
	}
	
	@Test
	public void testGetProfit() {

		/*ProjectStage ps = project.createStage();
		ProjectFinResultTransaction addedTransaction = project.addTransaction(ps);
		addedTransaction.setSum(10);
		assertEquals(project.getProfit(), 10);
		ProjectFinResultTransaction added2Transaction = project.addTransaction(ps);
		added2Transaction.setSum(-10);
		assertEquals(project.getProfit(), 0);
		*/
	}

}
