package ua.com.goit.gojava7.kickstarter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;
import ua.com.goit.gojava7.kickstarter.payment.PaymentSystem;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;

public class PaymentSystemTest {
	ProjectManager projectManager = new ProjectManager();
	Project project = new Project();
	User payer = new User();
	PaymentSystem paymentSystem = new PaymentSystem();

	@Before
	public void setUp() {
		projectManager.addProject(project);
		payer.setPaymentSystem(paymentSystem);
	}

	@Test
	public void testGetSetPaymentSystemName() {
		paymentSystem.setPaymentSystemName("Credit Card");
		assertThat(paymentSystem.getPaymentSystemName(), is("Credit Card"));
	}

	@Test
	public void testGetSetPaymentSystemID() {
		paymentSystem.setPaymentSystemID(1);
		assertThat(paymentSystem.getPaymentSystemID(), is(1));
	}

}
