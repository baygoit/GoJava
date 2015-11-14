package ua.com.goit.gojava7.kickstarter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import ua.com.goit.gojava7.kickstarter.exception.InsufficientFundsException;
import ua.com.goit.gojava7.kickstarter.exception.NoPaymentSystemException;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;

public class PaymentSystemTest {
	ProjectManager projectManager = new ProjectManager();
	Project project = new Project();
	User payer = new User();
	PaymentSystem paymentSystem = new PaymentSystem();
	
	@Before
	public void setUp(){
		projectManager.addProject(project);
		payer.setPaymentSystem(paymentSystem);
	}
	
	@Test
	public void testGetSetPaymentSystemName() {
		paymentSystem.setPaymentSystemName("Credit Card");
		assertThat(paymentSystem.getPaymentSystemName(),is("Credit Card"));
	}
	
	@Test
	public void testGetSetPaymentSystemID(){
		paymentSystem.setPaymentSystemID(1);
		assertThat(paymentSystem.getPaymentSystemID(),is(1));
	}
	
	@Test
	public void testPayMoney(){
		try {
			projectManager.userContributeToProject(project, payer, 1234.0);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( NoPaymentSystemException e){
			e.printStackTrace();
		}
		
		assertTrue(project.getBackers().containsKey(payer));
		assertTrue(project.getBackers().containsValue(1234));
	}
	
	@Test
	public void testPutWithdrawMoney(){
		paymentSystem.putMoney(4000);
		paymentSystem.withdrawMoney(1000);
		assertThat(paymentSystem.getBalance(), is(3000));
		
	}
	

	
	
	

}
