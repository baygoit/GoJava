package ua.com.goit.gojava7.kickstarter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;
import ua.com.goit.gojava7.kickstarter.payment.PaymentSystem;

public class PaymentSystemTest{
	DaoFactory		daoFactory		= new DaoFactory(DataSource.MEMORY);
	ProjectStorage	projectManager	= daoFactory.getProjectStorage();
	Project			project			= new Project();
	User			payer			= new User();
	PaymentSystem	paymentSystem	= new PaymentSystem();

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
